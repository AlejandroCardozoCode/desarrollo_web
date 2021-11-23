<template>
  <button class="boton">{{ msg }}</button>
</template>

<script lang="ts">
export default {
  name: "BotonV",
  props: {
    msg: {
      type: String,
      required: true,
    },
  },
};
</script>

<style scoped lang="scss">
.boton {
  margin-top: 5em;
  align-self: center;
  height: 2em;
  width: 7em;
  background: #68b0ab;
  color: white;
  border-radius: 2em;
  outline: none;
  border: none;
  font-family: "Roboto", sans-serif;
  font-size: 0.7em;
  margin-bottom: 5em;
}
</style>
