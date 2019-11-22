<template>
  <el-collapse-item title="图表" name="grid">
    <el-form :label-position="this.$root.$labelPosition" :label-width="this.$root.$labelWidth" :model="option" size="mini">
      <el-form-item label="图表边框">
        <el-switch v-model="option.grid.show"></el-switch>
      </el-form-item>
      <el-form-item label="边框颜色">
        <el-color-picker v-model="option.grid.borderColor" show-alpha :disabled="!option.grid.show"></el-color-picker>
      </el-form-item>
      <el-form-item label="图表背景">
        <el-color-picker v-model="option.grid.backgroundColor" show-alpha :disabled="!option.grid.show"></el-color-picker>
      </el-form-item>
      <el-form-item label="左边边距">
        <el-input-number v-model="left" :min="0" :max="100"></el-input-number>
      </el-form-item>
      <el-form-item label="右边边距">
        <el-input-number v-model="right" :min="0" :max="100"></el-input-number>
      </el-form-item>
      <el-form-item label="上边边距">
        <el-input-number v-model="top" :min="0" :max="100"></el-input-number>
      </el-form-item>
      <el-form-item label="下边边距">
        <el-input-number v-model="bottom" :min="0" :max="100"></el-input-number>
      </el-form-item>
    </el-form>
  </el-collapse-item>
</template>

<script>
    export default {
        name: "EChartsGrid",
        props: {
            option: Object
        },
        computed: {
            left:{
                get () {
                    try {
                        return parseFloat(this.option.grid.left.slice(0, -1));
                    }catch (e) {
                        return 1;
                    }
                },
                set (val) {
                    this.option.grid.left = val + "%";
                }
            },
            right:{
                get () {
                    try {
                        return parseFloat(this.option.grid.right.slice(0, -1));
                    }catch (e) {
                        return 1;
                    }
                },
                set (val) {
                    this.option.grid.right = val + "%";
                }
            },
            top:{
                get () {
                    try {
                        return parseFloat(this.option.grid.top.slice(0, -1));
                    }catch (e) {
                        return 1;
                    }
                },
                set (val) {
                    this.option.grid.top = val + "%";
                }
            },
            bottom:{
                get () {
                    try {
                        return parseFloat(this.option.grid.bottom.slice(0, -1));
                    }catch (e) {
                        return 1;
                    }
                },
                set (val) {
                    this.option.grid.bottom = val + "%";
                }
            }
        }
    }
</script>

<style scoped>

</style>
