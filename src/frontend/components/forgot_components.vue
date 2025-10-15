<script setup lang="ts"></script>
<template>
<div class="flex min-h-full flex-col justify-center px-6 py-12 lg:px-8 pt-40">
    <div class="sm:mx-auto sm:w-full sm:max-w-sm">

      <h2 class="mt-10 text-center text-2xl/9 font-bold tracking-tight text-white">Reset your password</h2>
    </div>
  
    <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
      <form action="#" method="POST" class="space-y-6">
        <div>
          <label for="email" class="block text-sm/6 font-medium text-gray-100">Email address</label>
          <div class="mt-2">
            <input id="email" type="email" name="email" required autocomplete="email" class="block w-full rounded-md bg-white/5 px-3 py-1.5 text-base text-white outline-1 -outline-offset-1 outline-white/10 placeholder:text-gray-500 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-500 sm:text-sm/6" />
          </div>
        </div>
  
       
  
        <div>
          <button type="submit" class="flex w-full justify-center rounded-md bg-indigo-500 px-3 py-1.5 text-sm/6 font-semibold text-white hover:bg-indigo-400 focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-500">Reset Password</button>
        </div>
      </form>
  
      <p class="mt-10 text-center text-sm/6 text-gray-400">
        You do not have an account ?
        <a href="/create" class="font-semibold text-indigo-400 hover:text-indigo-300">Create account</a>
      </p>
    </div>
  </div>
</template>
  