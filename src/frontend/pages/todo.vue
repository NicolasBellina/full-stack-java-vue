<template>
    <div class="p-6 space-y-6">
    <div>
      <h2 class="text-xl font-semibold mb-4">Todos</h2>

      <form class="flex gap-2 mb-4" @submit.prevent="addTodo">
        <input
          v-model="newTitle"
          type="text"
          placeholder="Nouvelle tâche"
          class="border rounded px-3 py-2 flex-1"
        />
        <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded" :disabled="adding">
          {{ adding ? 'Ajout…' : 'Ajouter' }}
        </button>
      </form>

      <div v-if="todosError" class="text-red-600 mb-2">Erreur: {{ todosError.message }}</div>

      <div v-if="todosPending">Chargement des tâches…</div>
      <ul v-else class="space-y-2">
        <li v-for="todo in todos || []" :key="todo.id" class="flex items-center justify-between border rounded px-3 py-2">
          <label class="flex items-center gap-2">
            <input type="checkbox" :checked="todo.completed" @change="toggleCompleted(todo)" />
            <span :class="{ 'line-through text-gray-500': todo.completed }">{{ todo.title }}</span>
          </label>
          <button class="text-sm text-red-600" @click="removeTodo(todo)" :disabled="removingIds.has(todo.id)">
            {{ removingIds.has(todo.id) ? 'Suppression…' : 'Supprimer' }}
          </button>
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup lang="ts">
type Todo = {
  id: number
  title: string
  completed: boolean
}

// Messages
const config = useRuntimeConfig()
const apiBase = config.public.apiBase as string
const { data: datahello, pending: pendingHello, error: errorHello } = await useFetch<string>('/api/messages/hello', { baseURL: apiBase })
const { data: databye, pending: pendingBye, error: errorBye } = await useFetch<string>('/api/messages/bye', { baseURL: apiBase })

// Todos
const { data: todos, pending: todosPending, error: todosError, refresh } = await useFetch<Todo[]>('/api/todo', { baseURL: apiBase })

const newTitle = ref('')
const adding = ref(false)
const removingIds = ref(new Set<number>())

async function addTodo() {
  const title = newTitle.value.trim()
  if (!title) return
  try {
    adding.value = true
    await $fetch('/api/todo', {
      method: 'POST',
      body: { title, completed: false },
      baseURL: apiBase
    })
    newTitle.value = ''
    await refresh()
  } finally {
    adding.value = false
  }
}

async function toggleCompleted(todo: Todo) {
  try {
    await $fetch(`/api/todo/${todo.id}`, {
      method: 'PUT',
      body: { ...todo, completed: !todo.completed },
      baseURL: apiBase
    })
    await refresh()
  } catch (e) {
  }
}

async function removeTodo(todo: Todo) {
  try {
    removingIds.value.add(todo.id)
    await $fetch(`/api/todo/${todo.id}`, { method: 'DELETE', baseURL: apiBase })
    await refresh()
  } finally {
    removingIds.value.delete(todo.id)
  }
}
</script>
