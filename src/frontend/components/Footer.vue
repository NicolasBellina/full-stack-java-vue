<script setup lang="ts">
import { NButton, NMenu } from 'naive-ui'

const menuOptions = [
  { label: 'Accueil', key: 'home' },
  { label: 'Docs', key: 'docs' }
]
</script>

<template>
  <footer class="flex items-center justify-between p-4 border-t">
    <NMenu :options="menuOptions" mode="horizontal" />
    <NButton type="primary">GitHub</NButton>
  </footer>
</template>
