<template>
  <div>
    <div class="bg"></div>
    <div class="nes-container is-centered" style="margin:5%;height:30rem;borderColor:transparent;">
      <i class="nes-kirby"></i>
      <div class="title" style="fontSize:9rem;color:#fff;marginBottom:5rem;">物资取用登记</div>
      <el-row type="flex" justify="center">
        <el-col :span="6">
          <div class="nes-btn is-size-1 is-warning" style="width:15rem;" @click="findAllUser">全部用户</div>
        </el-col>
        <el-col :span="6">
          <div class="nes-btn is-size-1 is-success" style="width:15rem;" @click="createOrder">新取用</div>
        </el-col>
        <el-col :span="6">
          <div class="nes-btn is-size-1 is-error" style="width:15rem;" @click="findAllOrders">历史记录</div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>
<script>
export default {
  created() {
    // 每次进首页都初始化三张总表
    this.$ajax.get("/findAllUser/0").then(response => {
      this.$storage.set("allUsers", response.data);
    });
    this.$ajax.get("/findorder/0").then(response => {
      this.$storage.set("allOrders", response.data);
    });
    this.$ajax.get("/finditem/0").then(response => {
      this.$storage.set("allItems", response.data);
    });
  },
  methods: {
    findAllUser() {
      this.$router.push("/User");
    },
    findAllOrders() {
      this.$router.push("/OrderList");
    },
    createOrder() {
      this.$router.push("/Items");
    }
  }
};
</script>
<style scoped>
el-col div {
  margin: 1rem;
}
.bg {
  /* 背景图的css简单写法，宽高撑满，位置不动，设置置顶，不然会被标题的margin影响到 */
  background-image: url("../assets/jpg/background.png");
  background-size: 100% 100%;
  height: 100%;
  position: fixed;
  width: 100%;
  top: 0;
}
</style>