# frontend

## Project setup
# Frontend (Nuxt)

This frontend folder is being prepared to run as a Nuxt 3 application.

Quick start

1. From this folder, install dependencies:

```bash
cd src/frontend
npm install
```

2. Start development server:

```bash
npm run dev
```

Notes

- `package.json` was updated to add `nuxt` and use `nuxi` scripts.
- `nuxt.config.ts` was adjusted to reference the existing CSS using `~/src/assets/css/main.css`.
- This project originally used Vue CLI. To complete the migration to Nuxt you will likely need to:
	- remove or adapt `src/main.js` (Nuxt provides its own entry),
	- move `src/App.vue` to `app.vue` (root layout) or follow Nuxt `app/` conventions,
	- create a `pages/` directory for routed pages (or `app/` + `pages` depending on needs),
	- remove Vue CLI dev dependencies when the migration is complete.

If you want, I can continue and:
- convert the app structure to Nuxt (move `App.vue` to `app.vue`, create `pages/`),
- remove Vue CLI dev deps,
- run `npm install` for you and start the dev server and verify Nuxt UI components work.

Troubleshooting

- If `nuxi` is not found after `npm install`, run `npx nuxi dev` or ensure `node_modules/.bin` is on your PATH.
- To use Nuxt UI components, import and test a simple component (I can add an example page).

---

Generated on 2025-10-10 by project assistant.
