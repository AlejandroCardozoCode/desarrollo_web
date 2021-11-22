<template>
  <div class="barra_input">
    <p>{{ titulo }}</p>
    <input type="text" class="input" id="nombre" />
  </div>
</template>

<script lang="ts">
export default {
  name: "Input",
  props: {
    titulo: {
      type: String,
      required: true,
    },
  },
  setup(props) {
    return props.titulo;
  },
};
</script>

<style scoped lang="scss"></style>
