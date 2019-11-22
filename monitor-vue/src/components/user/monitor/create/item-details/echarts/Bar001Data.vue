<template>
    <data-edit :dataOption="option.dataOption[0]" @calLBack="changeData"></data-edit>
</template>

<script>
    import DataEdit from "../../item-data/DataEdit";
    export default {
        name: "Bar001Data",
        props: {
            option: Object
        },
        components: {
            DataEdit
        },
        methods: {
            changeData(){
                this.option.itemOption.dataset = this.show(this.option.dataOption[0]);
            },
            show(option){
                if (option.type === 'fixed') { //固定数据，直接展示
                    return option.detail.data;
                }else if (option.type === 'request') { //接口数据，通过post请求
                    this.getRequestData(option.detail.address);
                }else if (option.type === 'database') { //数据库查询，通过数据源+sql检索
                    return option.example;
                }
            },
            getRequestData(url){
                this.axios
                    .post(
                        url
                    )
                    .then((res => {
                        this.option.itemOption.dataset = res.data.result;
                    }))
                    .catch(error => {
                        console.log(error);
                    });
            }
        }

    }
</script>

<style scoped>

</style>
