<template>
  <div class="flex min-h-full flex-col justify-center px-6 py-12 lg:px-8 pt-40">
    <div class="sm:mx-auto sm:w-full sm:max-w-lg">
      <h2 class="mt-2 text-center text-2xl/9 font-bold tracking-tight text-white">Create account</h2>
    </div>

    <div class="mt-8 sm:mx-auto sm:w-full sm:max-w-lg">
      <form @submit.prevent="submit" class="grid grid-cols-1 sm:grid-cols-2 gap-4">
        <div>
          <label for="firstName" class="block text-sm/6 font-medium text-gray-100">First Name</label>
          <input id="firstName" v-model="form.firstName" type="text" required class="mt-2 block w-full rounded-md bg-white/5 px-3 py-1.5 text-base text-white outline-1 -outline-offset-1 outline-white/10 placeholder:text-gray-500 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-500 sm:text-sm/6" />
        </div>
        <div>
          <label for="lastName" class="block text-sm/6 font-medium text-gray-100">Last Name</label>
          <input id="lastName" v-model="form.lastName" type="text" required class="mt-2 block w-full rounded-md bg-white/5 px-3 py-1.5 text-base text-white outline-1 -outline-offset-1 outline-white/10 placeholder:text-gray-500 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-500 sm:text-sm/6" />
        </div>

        <div>
          <label for="birthDate" class="block text-sm/6 font-medium text-gray-100">birth Date</label>
          <input id="birthDate" v-model="form.birthDate" type="date" required class="mt-2 block w-full rounded-md bg-white/5 px-3 py-1.5 text-base text-white outline-1 -outline-offset-1 outline-white/10 placeholder:text-gray-500 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-500 sm:text-sm/6" />
        </div>
        <div>
          <label for="country" class="block text-sm/6 font-medium text-gray-100">Country</label>
          <input id="country" v-model="form.country" type="text" required class="mt-2 block w-full rounded-md bg-white/5 px-3 py-1.5 text-base text-white outline-1 -outline-offset-1 outline-white/10 placeholder:text-gray-500 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-500 sm:text-sm/6" />
        </div>

        <div class="sm:col-span-2">
          <label for="email" class="block text-sm/6 font-medium text-gray-100">Email</label>
          <input id="email" v-model="form.email" type="email" required autocomplete="email" class="mt-2 block w-full rounded-md bg-white/5 px-3 py-1.5 text-base text-white outline-1 -outline-offset-1 outline-white/10 placeholder:text-gray-500 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-500 sm:text-sm/6" />
        </div>

        <div>
          <label for="password" class="block text-sm/6 font-medium text-gray-100">Password</label>
          <input id="password" v-model="form.password" type="password" required autocomplete="new-password" class="mt-2 block w-full rounded-md bg-white/5 px-3 py-1.5 text-base text-white outline-1 -outline-offset-1 outline-white/10 placeholder:text-gray-500 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-500 sm:text-sm/6" />
        </div>
        <div>
          <label for="confirmPassword" class="block text-sm/6 font-medium text-gray-100">Confirm Password</label>
          <input id="confirmPassword" v-model="form.confirmPassword" type="password" required autocomplete="new-password" class="mt-2 block w-full rounded-md bg-white/5 px-3 py-1.5 text-base text-white outline-1 -outline-offset-1 outline-white/10 placeholder:text-gray-500 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-500 sm:text-sm/6" />
        </div>

        <div class="sm:col-span-2">
          <button type="submit" class="w-full justify-center rounded-md bg-indigo-500 px-3 py-2 text-sm/6 font-semibold text-white hover:bg-indigo-400 focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-500" :disabled="submitting">
            {{ submitting ? 'Création…' : 'Create account' }}
          </button>
        </div>

        <p v-if="errorMessage" class="sm:col-span-2 text-sm text-red-400">{{ errorMessage }}</p>
        <p v-if="success" class="sm:col-span-2 text-sm text-green-400">Compte créé (simulation).</p>
      </form>

      <p class="mt-6 text-center text-sm/6 text-gray-400">
        Vous avez déjà un compte ?
        <a href="/login" class="font-semibold text-indigo-400 hover:text-indigo-300">Connexion</a>
      </p>
    </div>
  </div>
</template>

<script setup lang="ts">
import { reactive, ref } from 'vue'

type CreateForm = {
  firstName: string
  lastName: string
  birthDate: string
  country: string
  email: string
  password: string
  confirmPassword: string
}

const form = reactive<CreateForm>({
  firstName: '',
  lastName: '',
  birthDate: '',
  country: '',
  email: '',
  password: '',
  confirmPassword: ''
})

const submitting = ref(false)
const errorMessage = ref('')
const success = ref(false)

async function submit() {
  errorMessage.value = ''
  success.value = false
  if (!form.email || !form.password || !form.firstName || !form.lastName) {
    errorMessage.value = 'Veuillez remplir les champs obligatoires.'
    return
  }
  if (form.password !== form.confirmPassword) {
    errorMessage.value = 'Les mots de passe ne correspondent pas.'
    return
  }
  try {
    submitting.value = true
    await new Promise((r) => setTimeout(r, 600))
    success.value = true
  } finally {
    submitting.value = false
  }
}
</script>