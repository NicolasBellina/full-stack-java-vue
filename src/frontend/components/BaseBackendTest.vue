<template>
  <div class="flex flex-col items-center">
    <button
      @click="callBackend"
      class="bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700 mb-2"
    >
      Tester API Backend
    </button>
    <div v-if="backendMsg" class="mt-2 text-green-800 font-semibold">
      Réponse Backend : {{ backendMsg }}
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const backendMsg = ref('')

async function callBackend() {
  backendMsg.value = ''
  try {
    const res = await fetch('http://localhost:8080/api/messages/')
    if (!res.ok) throw new Error('Erreur API')
    backendMsg.value = await res.text()
  } catch (e) {
    backendMsg.value = "Échec d'appel backend"
  }
}
</script>

<script lang="ts">
export default {};
</script>
