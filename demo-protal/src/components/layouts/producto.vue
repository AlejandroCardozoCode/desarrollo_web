<template>
  <div class="fondo">
    <div class="imagenconten"><img class="imagen" v-bind:src="link" /></div>
    <div class="nombre">
      <p class="nombreP">{{ nombre }}</p>
      <p>${{ precio }}</p>
    </div>
    <Boton class="boton" msg="Agregar"></Boton>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import Boton from "@/components/boton.vue";
export default defineComponent({
  name: "Producto",
  props: {
    nombre: String,
    link: String,
    precio: String,
  },
  components: { Boton },
});
</script>

<style scoped lang="scss">
p {
  margin-bottom: 0.3em;
}
.fondo {
  width: 20em;
  height: 20em;
  background: white;
  border-radius: 1em;
  text-align: center;
  margin: 1em;
  border-style: solid;
  border-color: #68b0ab;
  border-width: 0.15em;
}

.nombre {
  font-family: "Roboto", sans-serif;
  font-weight: bold;
  padding-left: 1em;
}
.imagenconten {
  padding: 1em;
  display: block;
  height: 15em;
  width: 15em;
  margin: 0 auto;
}
.imagen {
  max-width: 100%;
  max-height: 100%;
}
.nombreP {
  font-size: 1em;
}
.nombre {
  margin-top: -1em;
}

.boton {
  margin-top: 0.5em;
}
</style>
