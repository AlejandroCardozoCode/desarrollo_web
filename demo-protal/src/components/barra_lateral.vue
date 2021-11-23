import component from '../shims-vue';
<template>
  <div class="barra_lateral">
    <div class="contenedor">
      <h1>Menu</h1>
      <dl>
        <dt>Cliente</dt>
        <dd><a href="https://www.w3schools.com/"></a></dd>
        <p></p>
        <dt>Doctor</dt>
        <dd>
          <a href="http://localhost:8080/cambiar_contra_doc"
            >Cambiar contraseña</a
          >
        </dd>
        <dd>
          <a href="http://localhost:8080/actualizar_hi">Cambiar hora inicial</a>
        </dd>
        <dd>
          <a href="http://localhost:8080/actualizar_hf">Cambiar hora final</a>
        </dd>
        <dd>
          <a href="http://localhost:8080/agregar_paciente">Agregar Paciente</a>
        </dd>
        <p></p>
        <dt>Admin</dt>
        <dd></dd>
        <a href="http://localhost:8080/crear_doctor">Crear Doctor</a>
        <dd></dd>
        <a href="http://localhost:8080/eliminar_doc">Eliminar Doctor</a>
      </dl>
    </div>
  </div>
</template>
<script lang="ts">
export default {
  name: "Barra_lateral",
};
</script>

<style scoped lang="scss">
p,
h1 {
  margin-top: 0.5em;
  margin-bottom: 0.5em;
  font-family: "Roboto", sans-serif;
  color: #faf3dd;
}
a {
  color: #faf3dd;
}
dt {
  color: #faf3dd;
  font-weight: bold;
  margin-bottom: 0.5em;
}
dd {
  margin-left: 1em;
}
.barra_lateral {
  background: #68b0ab;
  display: flex;
  flex-direction: column;
  grid-column: 1/2;
  align-items: center;
  padding-top: 5em;
  font-family: "Roboto", sans-serif;
  color: #faf3dd;
  justify-content: center;
}
.contenedor {
  align-items: center;
  font-size: 1.5em;
  font-family: "Roboto", sans-serif;
  color: #faf3dd;
}
</style>
