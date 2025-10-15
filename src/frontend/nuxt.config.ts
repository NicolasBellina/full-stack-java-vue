export default defineNuxtConfig({
    modules: ['@nuxt/ui'],
    css: ['~/assets/css/main.css'],
    runtimeConfig: {
        public: {
            apiBase: 'http://localhost:8080'
        }
    },
    routeRules: {
        '/api/**': {
            proxy: 'http://localhost:8080'
        }
    },
    vite: {
        server: {
            proxy: {
                '/api': {
                    target: 'http://localhost:8080',
                    changeOrigin: true
                }
            }
        }
    },
    nitro: {
        devProxy: {
            '/api/': {
                target: 'http://localhost:8080',
                changeOrigin: true
            }
        }
    }
})