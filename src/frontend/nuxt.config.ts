import { defineNuxtConfig } from 'nuxt/config'
export default defineNuxtConfig({
    modules: ['@nuxt/ui'],
    css: ['~/assets/css/main.css'],
    postcss: {
        plugins: {
            tailwindcss: {},
            autoprefixer: {}
        }
    },
    compatibilityDate: '2025-10-10',
    // Proxy fiable via Nitro: redirige /api/** vers le backend en dev
    routeRules: {
        '/api/**': { proxy: 'http://localhost:8080/api/**' }
    }
})
// No implementation needed here - defineNuxtConfig is provided by Nuxt