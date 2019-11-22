<template>
  <div class="block">
    <div class="detail" :style="option.itemOption">Title</div>
  </div>
</template>

<script>
    export default {
        name: "Title001",
        data(){
            return{
            }
        },
        props: {
            option: {}
        },
        methods: {
            resize(){

            },
            initOption(){
                //如果没有被编辑过，加入初始值
                if (!this.option.isEdit) {
                    this.option.itemOption = {
                        color: '#000000'
                    };
                }
            }
        },
        mounted() {
            this.option.mainOption.editType = 'title-1';
            this.initOption();
        },
        watch: {
            option: {
                immediate:true,
                deep: true,
                handler(val){

                }
            }
        }
    }
</script>

<style scoped>
  .block{
    height: 100%;
    width: 100%;
    display: flex;
  }
  .detail{
    margin: auto;
  }
</style>
