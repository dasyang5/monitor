<template>
  <el-collapse v-model="activeName" accordion>
    <el-collapse-item title="基础" name="basic">
      <el-form :label-position="this.$root.$labelPosition" :label-width="this.$root.$labelWidth" :model="option" size="mini">
        <el-form-item label="标题颜色">
          <el-color-picker v-model="option.color" show-alpha></el-color-picker>
        </el-form-item>
      </el-form>
    </el-collapse-item>
  </el-collapse>
</template>

<script>
    export default {
        name: "Title001StyleEdit",
        props: {
            option: Object,
            activeName: 'basic'
        }
    }
</script>

<style scoped>

</style>
