<template>
  <div class="flex flex-col items-center justify-center min-h-screen bg-gradient-to-br from-blue-100 to-cyan-100">
    <h1 class="text-3xl font-extrabold mb-8 text-blue-700 drop-shadow">Todos persistant en base</h1>
    <div class="flex mb-4">
      <input v-model="newTodo"
             placeholder="Ajouter une todo"
             @keyup.enter="addTodo"
             class="border-2 border-blue-400 focus:border-blue-700 focus:ring-2 focus:ring-blue-100 outline-none rounded px-4 py-2 w-80 bg-white text-gray-800 placeholder-blue-300 shadow"/>
      <button @click="addTodo"
              class="ml-2 bg-blue-600 text-white px-6 py-2 rounded-lg hover:bg-blue-800 focus:outline-none focus:ring-2 focus:ring-blue-400 font-semibold shadow transition">Ajouter</button>
    </div>
    <ul v-if="todos.length" class="bg-white rounded-lg shadow-lg p-4 w-80 mb-8 border border-blue-100">
      <li v-for="todo in todos" :key="todo.id"
          class="border-b text-blue-700 last:border-b-0 py-1 font-medium flex items-center justify-between">
        <span :class="{ 'line-through': todo.completed }">{{ todo.title }}</span>
        <button @click="deleteTodo(todo.id)" class="ml-2 text-red-500 hover:text-red-700 font-bold">X</button>
      </li>
    </ul>
    <div v-else class="text-blue-400 mb-8">Aucune todo enregistrée dans la base.</div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'

type Todo = {
  id: number
  title: string
  completed: boolean
}

const todos = ref<Todo[]>([])
const newTodo = ref('')

async function fetchTodos() {
  const res = await fetch('http://localhost:8080/api/todo')
  todos.value = await res.json()
}

async function addTodo() {
  if (!newTodo.value.trim()) return
  await fetch('http://localhost:8080/api/todo', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ title: newTodo.value, completed: false }),
  })
  newTodo.value = ''
  await fetchTodos()
}

async function deleteTodo(id: number) {
  await fetch(`http://localhost:8080/api/todo/${id}`, {
    method: 'DELETE',
  })
  await fetchTodos()
}

onMounted(() => {
  fetchTodos()
})
</script>