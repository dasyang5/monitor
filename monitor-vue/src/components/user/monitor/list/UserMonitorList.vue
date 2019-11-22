<template>
    <el-container>
        <el-main>
            <template>
                <el-table
                    :data="array"
                    style="width: 100%">
                    <el-table-column
                        prop="id"
                        label="ID">
                    </el-table-column>
                    <el-table-column
                        prop="title"
                        label="标题">
                    </el-table-column>
                    <el-table-column label="操作">
                        <template slot-scope="scope">
                            <el-button size="mini" @click="edit(scope.row.id)">编辑</el-button>
                            <el-button size="mini" @click="view(scope.row.id)" type="success">预览</el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </template>
        </el-main>
    </el-container>
</template>

<script>
    import qs from 'qs'
    export default {
        name: "UserMonitorList",
        data(){
            return {
                array: null
            }
        },
        methods: {
            getData(){
                this.axios
                    .post(
                        '/server/monitor/list/'
                    )
                    .then((res => {
                        this.array = res.data.items;
                    }))
                    .catch(error => {
                        console.log(error);
                        this.$message.error('查询失败');
                    });
            },
            edit(id){
                this.axios
                    .post(
                        '/server/monitor/list/showDetail',
                        qs.stringify({
                            'id': id
                        })
                    )
                    .then((res => {
                        this.$router.push({path: "/user/monitor/create/add",query: {
                                'id': res.data.item.id,
                                'result': res.data.item.result
                            }})
                    }))
                    .catch(error => {
                        console.log(error);
                        this.$message.error('查询失败');
                    });
            },
            view(id){
                let {href} = this.$router.resolve({
                    path: "/user/monitor/view",
                    query: {
                        'id': id
                    }
                });
                window.open(href, '_blank');
            }
        },
        mounted() {
            this.getData();
        }
    }
</script>

<style scoped>

</style>
