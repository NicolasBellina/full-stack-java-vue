// vue.config.js
module.exports = {
  transpileDependencies: [],
  devServer: {
    port: 3000,
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        ws: true,
        changeOrigin: true
      }
    }
  },
  configureWebpack: config => {
    // Supprime tout plugin Progress s'il est injecté automatiquement
    config.plugins = config.plugins.filter(
      p => p.constructor.name !== 'ProgressPlugin'
    )
  }
}