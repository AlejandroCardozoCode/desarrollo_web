<template>
  <div class="wrapper-layout">
    <Header title="Agregar Historia Clinica" class="header"></Header>
    <nav>Barra</nav>
    <section>contenido</section>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import Header from "@/components/layouts/Header.vue";
export default defineComponent({
  name: "AgregarHC",
  components: {
    Header,
  },
});
</script>

<style scoped lang="scss">
.wrapper-layout {
  display: grid;
  grid-template-columns: 200px 1fr;
  grid-template-rows: 100px 1fr;
  height: 100vh;
}
.header {
  grid-column: 2/3;
  grid-row: 1/2;
  background-color: #faf3dd;
}
</style>
