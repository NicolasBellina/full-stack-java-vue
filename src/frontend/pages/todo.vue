<template>
  <div class="pt-32 p-6 space-y-6">
    <div>
      <h2 class="text-xl font-semibold mb-4"></h2>

      <div class="flex items-center gap-2 mb-2">
        <input
          v-model="search"
          type="text"
          placeholder="Rechercher une tâche"
          class="border rounded px-3 py-2 flex-1"
        />
        <select v-model.number="size" class="border rounded px-2 py-2">
          <option :value="5">5</option>
          <option :value="10">10</option>
          <option :value="20">20</option>
        </select>
      </div>

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

      <div v-if="pageError" class="text-red-600 mb-2">Erreur: {{ pageError.message }}</div>

      <div class="flex items-center justify-between text-sm text-gray-600 mb-1" v-if="pageData">
        <div>
          {{ pageData.totalElements }} élément(s) • page {{ page + 1 }} / {{ pageData.totalPages }}
        </div>
        <div class="flex gap-2">
            <UButton color="gray" @click="prevPage" :disabled="page === 0">Précédent</UButton>
            <UButton color="gray" @click="nextPage" :disabled="pageData && page + 1 >= pageData.totalPages">Suivant</UButton>
        </div>
      </div>

      <div v-if="pagePending">Chargement des tâches…</div>
      <ul v-else class="space-y-2">
        <li v-for="todo in (pageData?.content || [])" :key="todo.id" class="flex items-center justify-between border rounded px-3 py-2">
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

type PageResponse<T> = {
  content: T[]
  totalElements: number
  totalPages: number
  number: number
  size: number
}

// Recherche + pagination (chargement côté client pour éviter le cache SSR)
const search = ref('')
const debouncedSearch = ref('')
let debounceTimer: any
watch(search, (val) => {
  clearTimeout(debounceTimer)
  debounceTimer = setTimeout(() => {
    debouncedSearch.value = val
    page.value = 0
  }, 300)
})

const page = ref(0)
const size = ref(10)

const { data: pageData, pending: pagePending, error: pageError, refresh } = await useFetch<PageResponse<Todo>>(
  () => '/api/todo/page',
  {
    server: false,
    immediate: true,
    query: {
      q: debouncedSearch,
      page,
      size,
      sort: 'id,DESC'
    },
    watch: [debouncedSearch, page, size]
  }
)

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
  headers: { 'Content-Type': 'application/json' },
  body: { title, completed: false }
})
    newTitle.value = ''
    await refresh()
  } finally {
    adding.value = false
  }
}

async function toggleCompleted(todo: Todo) {
  try {
    await fetch(`/api/todo/${todo.id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ ...todo, completed: !todo.completed }),
    })
    await refresh()
  } catch (e) {
  }
}

async function removeTodo(todo: Todo) {
  try {
    removingIds.value.add(todo.id)
    await fetch(`/api/todo/${todo.id}`, { method: 'DELETE' })
    await refresh()
  } finally {
    removingIds.value.delete(todo.id)
  }
}

function nextPage() {
  if (pageData.value && page.value + 1 < pageData.value.totalPages) {
    page.value += 1
  }
}

function prevPage() {
  if (page.value > 0) {
    page.value -= 1
  }
}

</script>

