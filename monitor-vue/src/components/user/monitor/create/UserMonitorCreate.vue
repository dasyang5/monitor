<template>
  <el-main>
    <el-row>
      <el-col :span="4" style="padding: 15px">
        <div :style="{ height:blockHeight }">
          <div class="add-mon" :style="{ border: '1px dashed ' + addMonColor }"
               @mouseenter="mouseEnter" @mouseleave="mouseLeave" @click="addNewMonitor">
            <i class="el-icon-plus"></i>
          </div>
        </div>
      </el-col>

      <el-col :span="4" class="mon-block"><div :style="{ height:blockHeight }"></div></el-col>
      <el-col :span="4" class="mon-block"><div :style="{ height:blockHeight }"></div></el-col>
      <el-col :span="4" class="mon-block"><div :style="{ height:blockHeight }"></div></el-col>
      <el-col :span="4" class="mon-block"><div :style="{ height:blockHeight }"></div></el-col>
      <el-col :span="4" class="mon-block"><div :style="{ height:blockHeight }"></div></el-col>
      <el-col :span="4" class="mon-block"><div :style="{ height:blockHeight }"></div></el-col>
      <el-col :span="4" class="mon-block"><div :style="{ height:blockHeight }"></div></el-col>

    </el-row>
  </el-main>
</template>

<script>
    export default {
        name: "UserMonitor",
        data(){
            return {
                addMonColor: 'gray'
            }
        },
        computed: {
            blockHeight: function () {
                //设置高度，使展示块显示为正方形
                return ((document.body.clientWidth / 6) - 40) + 'px';
            }
        },
        methods: {
            mouseEnter(){
                this.addMonColor = '#00FFFF';
            },
            mouseLeave(){
                this.addMonColor = '#c4c4c4';
            },
            //添加数字大屏
            addNewMonitor(){
                this.$router.push("/user/monitor/create/add")
            }
        }
    }
</script>

<style scoped>
  .mon-block {
    padding: 15px;
  }

  .mon-block div:first-of-type {
    background-color: #c4c4c4;
  }

  .add-mon {
    width: 100%;
    height: 100%;
    text-align: center;
    display: table;
    border-radius: 10px;
  }

  .add-mon i{
    display: table-cell;
    vertical-align: middle;
    font-size: 25px;
  }
</style>
