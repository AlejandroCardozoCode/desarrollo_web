<template>
  <header class="header header-visual">
    <p class="title">{{ title }}</p>
  </header>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "Header",
  props: {
    title: {
      type: String,
      required: true,
    },
  },
});
</script>

<style scoped lang="scss">
.header-visual {
  background-color: #faf3dd;
  .title {
    border-bottom: 2px solid #68b0ab;
    font-family: "Roboto", sans-serif;
    width: 96%;
    margin: 0 auto;
    padding: 1rem 0rem;
    font-size: 1.5rem;
    font-weight: 700;
  }
}
</style>
