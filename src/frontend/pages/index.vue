<template>
  <div class="p-6 space-y-6">
    <div>
      <h2 class="text-xl font-semibold mb-2">Message backend</h2>
      <h1 v-if="data" class="text-2xl">{{ data }}</h1>
      <p v-else-if="pending">Chargement...</p>
      <p v-else-if="error">Erreur: {{ error.message }}</p>
    </div>
  </div>
  
</template>

<script setup lang="ts">
const { data, pending, error } = await useFetch<string>('/api/messages/hello')
</script>

