<template>
  <div class="wrapper_principal">
    <Header title="Tienda Deweb" class="header"></Header>
    <Barra_lateral class="sidebar"></Barra_lateral>
    <div class="pantalla">
      <table class="tabla">
        <tr>
          <th>
            <Producto
              nombre="Alimento Húmedo"
              link="https://laikapp.s3.amazonaws.com/dev_images_products/1479_105558_Pedigree_Alimento_H__medo_Para_Perro_Adulto_Carne_Sobre_1630976533_500x500.png"
              precio="3.000"
            ></Producto>
          </th>
          <th>
            <Producto
              nombre="Spider-man Costume"
              link="https://laikapp.s3.amazonaws.com/dev_images_products/70595_Disfraces_Americanos___Pet_walking_spider_man_1633534693_0_500x500.jpg"
              precio="132.700"
            ></Producto>
          </th>
          <th>
            <Producto
              nombre="Adaptil Collar"
              link="https://laikapp.s3.amazonaws.com/dev_images_products/16217_ADAPTIL_COLLAR_1596897884_600x600.png"
              precio="64.530"
            ></Producto>
          </th>
          <th>
            <Producto
              nombre="Splend Dog -Desparasitante"
              link="https://s3.us-east-1.amazonaws.com/laikapp/images_products/48265f93466e2a0d072b7925895c07b5.jpg"
              precio="7.000"
            ></Producto>
          </th>
        </tr>
        <tr>
          <th>
            <Producto
              nombre="Canisan Puppy"
              link="https://s3.us-east-1.amazonaws.com/laikapp/images_products/98aa72d4467e0ec24403394b3e90e76c.jpg"
              precio="6.750"
            ></Producto>
          </th>
          <th>
            <Producto
              nombre="Septiderm Clorhexidina"
              link="https://s3.us-east-1.amazonaws.com/laikapp/images_products/d27f311d210b245bd02c3c3889a56c5f.JPG"
              precio="7.605"
            ></Producto>
          </th>
          <th>
            <Producto
              nombre="Ardilla Con Sonido Camel"
              link="https://laikapp.s3.amazonaws.com/dev_images_products/15679_35621_ARDILLA_CON_SONIDO_1608145366_2859x1899.jpg"
              precio="43.100"
            ></Producto>
          </th>
          <th>
            <Producto
              nombre="Erizo Con Sonido"
              link="https://laikapp.s3.amazonaws.com/dev_images_products/15661_ERIZO_CON_SONIDO_1596606855_1000x1000.jpg"
              precio="28.100"
            ></Producto>
          </th>
        </tr>
      </table>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import Barra_lateral from "@/components/barra_lateral.vue";
import Header from "@/components/layouts/Header.vue";
import Producto from "@/components/layouts/producto.vue";
export default defineComponent({
  name: "Tienda",
  components: { Barra_lateral, Header, Producto },
});
</script>

<style scoped lang="scss">
h1 {
  margin-left: 2.4em;
  margin-top: 2em;
}
.wrapper_principal {
  display: grid;
  grid-template-columns: 200px 1fr;
  grid-template-rows: 100px 1fr;
  height: 100vh;
}
.header {
  grid-column: 2/3;
  grid-row: 1/2;
}
.sidebar {
  grid-column: 1/2;
  grid-row: 1/3;
  background-color: #68b0ab;
  font-size: 0.7em;
}

.barra_lateral {
  background: #68b0ab;
  display: flex;
  flex-direction: column;
  grid-column: 1 / 2;
}
.contededor_formulario {
  margin-top: 5em;
}
.pantalla {
  background: #faf3dd;
  display: flex;
  flex-direction: column;
  grid-column: 2 / 3;
  font-family: "Roboto", sans-serif;
  font-size: 1.2em;
  justify-content: center;

  .barra_input {
    margin-top: 1.2em;
    margin-left: 5em;
    margin-right: 5em;
  }
}
.input {
  padding-left: 0.5em;
  margin-top: 0.5em;
  height: 1.5em;
  background: white;
  color: #47525e;
  width: 100%;
  font-family: "Roboto", sans-serif;
  font-size: 1em;
  border-style: solid;
  border-color: #68b0ab;

  outline: none;
  border-radius: 0.5em;
}
</style>
