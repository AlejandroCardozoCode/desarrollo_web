<template>
  <div class="wrapper-login">
    <div class="form-login">
      <p class="login-title">Veterinaria Deweb</p>
      <div class="wrapper-input">
        <label for="user" class="tag-input-login">Usuario</label>
        <input type="text" class="input-login" id="user" />
      </div>
      <div class="wrapper-input">
        <label for="user" class="tag-input-login">Contraseña</label>
        <input type="password" class="input-login" id="password" />
        <Boton msg="Ingresar"></Boton>
      </div>
      <input type="submit" value="Ingresar" class="submit-login" />

      <a class="botonl" href="http://localhost:8080/crear_doctor"
        >Cambiar hora inicial</a
      >
    </div>
    <div class="image-login">
      <figure class="wrapper-image">
        <img src="@/assets/perro-slide_0.jpg" alt="" class="dog-image" />
        <p class="login-description">Veterinaria Deweb</p>
        <p class="login-description2">
          Cuidamos a tu mascota como tú lo harías
        </p>
      </figure>
    </div>
  </div>
</template>

<script Lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "login",
  crear() {
    alert("lkajflaj");
  },
});
</script>

<style scoped lang="scss">
.botonl {
  margin-top: -1.5em;
  color: transparent;
}
.wrapper-login {
  height: 100vh;
  overflow: hidden;
  background-color: #ffffffff;
  display: grid;
  grid-template-columns: 1.5fr 2fr;
  font-family: "Roboto Light";
}
.form-login {
  background-color: #faf3dd;
  grid-column: 1/2;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  .login-title {
    font-family: "Roboto Light";
    font-size: 2rem;
    color: #08afaf;
    margin-bottom: 2rem;
    font-weight: 700;
  }
  .wrapper-input {
    display: flex;
    flex-direction: column;
    width: 80%;
    margin: 1rem auto;
    .input-login {
      padding: 0.5rem 0.5rem;
      outline: none;
      border-radius: 0.5rem;
      border: #08afaf 1.5px solid;
    }
    .tag-input-login {
      font-size: 1.2rem;
      margin-bottom: 0.2rem;
    }
  }
  .submit-login {
    border: none;
    padding: 0.5rem 3rem;
    border-radius: 0.5rem;
    background-color: #68b0ab;
    color: #ffffffff;
    font-size: 1.2rem;
    margin-top: 1rem;
  }
}
.image-login {
  background-color: #68b0ab;
  grid-column: 2/3;

  .wrapper-image {
    display: flex;
    flex-direction: column;
    align-items: center;
    .dog-image {
      width: 35rem;
      height: 35rem;
      border-radius: 50%;
    }
    .login-description {
      font-family: "Roboto Light";
      font-size: 2rem;
      color: #070707;
      margin-bottom: 2rem;
      font-weight: 700;
    }
    .login-description2 {
      font-family: "Roboto Light";
      font-size: 1rem;
      color: #070707;
      margin-bottom: 1rem;
    }
  }
}
</style>
