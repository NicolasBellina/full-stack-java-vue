<template>
  <div class="p-6 space-y-6">
    <div>
      <h2 class="text-xl font-semibold mb-2">Message backend</h2>
      <h1 v-if="datahello" class="text-2xl">{{ datahello }}</h1>
      <p v-else-if="pendingHello">Chargement...</p>
      <p v-else-if="errorHello">Erreur: {{ errorHello.message }}</p>
    </div>
  </div>

  <div class="p-6 space-y-6">
    <div>
      <h2 class="text-xl font-semibold mb-2">Message backend</h2>
      <h1 v-if="databye" class="text-2xl">{{ databye }}</h1>
      <p v-else-if="pendingBye">Chargement...</p>
      <p v-else-if="errorBye">Erreur: {{ errorBye.message }}</p>
    </div>
  </div>
</template>

<script setup lang="ts">
const { data: datahello, pending: pendingHello, error: errorHello } = await useFetch<string>('/api/messages/hello')
const { data: databye, pending: pendingBye, error: errorBye } = await useFetch<string>('/api/messages/bye')
</script>
