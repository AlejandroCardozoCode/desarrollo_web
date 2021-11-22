<template>
  <div class="wrapper-login">
    <div class="form-login">
      <p class="Login-tittle">Login</p>
      <div class="wrapper-input">
        <label for="user">Usuario</label>
        <input type="text" class="input-login" id="user" />
        <label for="contra">Contraseña</label>
        <input type="password" class="input-login" id="contra" />
      </div>
    </div>
    <div class="image-login">
      <div class="foto">
        <label class="tituloVet">Veterinaria</label>
        <img
          src="https://cdn.discordapp.com/attachments/743599721368780851/912107667634421800/mqdefault.jpg"
          class="foto2"
        />
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "testLogin",
});
</script>

<style scoped lang="scss">
.wrapper-login {
  height: 100vh;
  overflow: hidden;
  background-color: rgb(172, 172, 172);
  grid-template-columns: 1fr, 3fr;
  display: grid;
}
.wrapper-input {
  display: flex;
  flex-direction: column;
  .input-login {
    padding: 0.5rem;
    outline: none;
    border-radius: 0.5rem;
    border: none;
    margin-bottom: 2rem;
  }
}

.form-login {
  background-color: #09a06e;
  color: white;
  grid-column: 1 / 2;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  .Login-tittle {
    font-size: 2rem;
    font-family: "Courier New", Courier, monospace;
    margin-bottom: 3rem;
  }
}

.image-login {
  background-color: rgb(219, 209, 209);
  color: white;
  grid-column: 2 / 3;
  align-items: center;
  display: flex;
  flex-direction: column;
  justify-content: center;
  .foto {
    -webkit-text-stroke: 0.05rem black;
    display: flex;
    flex-direction: column;
    font-size: 4rem;
    border-radius: 1rem;
    .tituloVet {
      margin-bottom: 3rem;
    }
    .foto2 {
      border-radius: 50%;
      height: 20rem;
      width: 20rem;
    }
  }
}
</style>
