<template>
  <div class="tool-main">
    <el-row>
      <el-col :span="12">
        <el-dropdown  @command="handleCommand">
          <span class="el-dropdown-link">
            <div>
                          <i class="el-icon-caret-left" style="margin: 40px 0px"></i>
            </div>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="add"><i class="el-icon-plus"></i></el-dropdown-item>
            <el-dropdown-item command="cancel"><i class="el-icon-close"></i></el-dropdown-item>
            <el-dropdown-item command="finish"><i class="el-icon-check"></i></el-dropdown-item>
            <el-dropdown-item command="edit"><i class="el-icon-more"></i></el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-col>
    </el-row>
  </div>
</template>

<script>
    export default {
        name: "CreateTopBar",
        methods: {
            add(){
                this.$emit("addItem");
            },
            cancel(){
                this.$confirm('确定要放弃保存编辑的内容吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$router.push("/user/monitor/create/")
                }).catch(() => {

                });
            },
            finish(){
                this.$emit("finish");
            },
            edit(){
                this.$root.monitorMainEdit.show();
            },
            handleCommand(command){
                if (command === 'add') {
                    this.add();
                }else if (command === 'cancel') {
                    this.cancel();
                }else if (command === 'finish') {
                    this.finish();
                }else if (command === 'edit') {
                    this.edit();
                }
            }
        }
    }
</script>

<style scoped>
  .tool-main {
    position: fixed;
    top: 45%;
    right: 0;
    border: 1px solid rgba(141, 176, 186, 0.29);
    z-index: 999;
    background-color: #ffb978;
    border-radius: 4px;
  }
  .tool-main:hover{
    background-color: #ff8224;
  }
  .tool-btn{
    margin: 3px;
  }
</style>
