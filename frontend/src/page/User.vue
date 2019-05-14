<template>
  <div>
    <!-- <div class="nes-container">
            <button type="button" class="nes-btn is-primary" @click="showdialog">弹窗测试</button>
            
    </div>-->
    <!-- <hr> -->
    <div class="bg"></div>

    <div class="nes-container with-title is-centered" style="margin:5%;backgroundColor:#fff;">
      <span class="title" style="fontSize:3rem;color:#f7d51d;">☆ 取用物资人员 ☆</span>

      <div style="display:flex;justify-content:space-between;margin:1rem;">
        <div class="nes-btn is-size-1" style="width:25rem" @click="routerBack">返回</div>
        <div class="nes-btn is-size-1 is-primary" style="width:25rem" @click="getOrderList">用户订单</div>
        <div class="nes-btn is-error is-size-1" style="width:25rem" @click="deleteUser">删除</div>
      </div>
      <div class="customcontain">
        <div
          class="nes-container with-title membercard"
          v-for="(item,index) in allUsers"
          :key="index"
          style="margin:1rem"
          :class="{selectCSS:index==selectFlag}"
          @click="selectCssMethod(index)"
        >
          <span class="title" style="fontSize:2rem;color:#209cee;">{{item.userName}}</span>
          <div>
            <span style="color:#92cc41;fontWeight:bold;">性别：</span>
            {{item.userSex}}
          </div>
          <div>
            <span style="color:#92cc41;fontWeight:bold;">生日：</span>
            {{item.userBirthday}}
          </div>
          <div>
            <span style="color:#92cc41;fontWeight:bold;">住址：</span>
            {{item.userAddress}}
          </div>
        </div>
      </div>
      <div class="nes-container with-title" style="margin:1rem;">
        <span class="title" style="color:#e76e55;fontSize:2rem;">新增/修改用户</span>
        <div style="margin:10px;">
          <span style="fontSize:2rem;">姓名：</span>
          <input type="text" class="nes-input" style="width:90%;" v-model="userTemp.userName">
        </div>
        <div style="margin:10px;">
          <span style="fontSize:2rem;">性别：</span>
          <input type="text" class="nes-input" style="width:90%;" v-model="userTemp.userSex">
        </div>
        <div style="margin:10px;">
          <span style="fontSize:2rem;">生日：</span>
          <input type="text" class="nes-input" style="width:90%;" v-model="userTemp.userBirthday">
        </div>
        <div style="margin:10px;">
          <span style="fontSize:2rem;">地址：</span>
          <input type="text" class="nes-input" style="width:90%;" v-model="userTemp.userAddress">
        </div>
        <div class="nes-btn is-success is-size-1" style="width:100%" @click="addUser">新增/修改</div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      selectFlag: -1,
      allUsers: this.$storage.get("allUsers"),
      delKey: "需要删除的主键",
      UpdateKey: "需要更新的主键",
      userTemp: {
        userName: "请输入用户姓名",
        userSex: "请输入用户性别",
        userBirthday: "请输入用户生日（示例：1993-03-07）",
        userAddress: "请输入用户地址"
      },
      summitUrl: "/addUser"
    };
  },
  methods: {
    routerBack() {
      this.$router.back(-1);
    },
    sleep(d) {
      for (var t = Date.now(); Date.now() - t <= d; );
    },
    reflash() {
      this.$ajax.get("/findAllUser/0").then(response => {
        this.allUsers = response.data;
        this.$storage.set("allUsers", response.data);
        this.summitUrl = "/addUser";
        this.selectFlag = -1;
        for (let key in this.userTemp) {
          this.userTemp[key] = "";
        }
      });
    },
    deleteUser() {
      let urlTemp =
        "/deleteUserByPrimaryKey/" + this.allUsers[this.selectFlag].userId;
      this.$ajax.get(urlTemp).then(response => {
        if (response.data == 1) {
          console.log("删除成功");
        } else {
          console.log("删除失败");
        }
        this.reflash();
      });
    },
    addUser() {
      this.allUsers.forEach(element => {
        if (element.userName == this.userTemp.userName) {
          this.summitUrl = "/updateUser";
          this.userTemp["userId"] = element["userId"];
          return false;
        }
      });
      this.$ajax.post(this.summitUrl, this.userTemp).then(response => {
        if (response.data != 0) {
          console.log("更新成功");
        } else {
          console.log("更新失败");
        }
        this.reflash();
      });
    },
    getOrderList() {
      if (this.selectFlag != -1) {
        let url = "/findorder/" + this.allUsers[this.selectFlag].userId;
        this.$ajax.post(url).then(response => {
          this.$storage.set("allOrders", response.data);
          // 路由跳转要写进axios的回调里
          this.$router.push({
            name: "orderlist",
            params: {
              userFlag: "show",
              userOrder: this.allUsers[this.selectFlag].userName
            }
          });
        });
      } else {
        this.$ajax.post("/findorder/0").then(response => {
          this.$storage.set("allOrders", response.data);
          this.$router.push({
            name: "orderlist",
            params: { userFlag: "none", userOrder: "" }
          });
        });
      }
    },
    selectCssMethod(index) {
      if (this.selectFlag != index) {
        this.selectFlag = index;
      } else {
        this.selectFlag = -1;
      }
    }
  }
};
</script>
<style scope>
.customcontain {
  display: flex;
  flex-wrap: wrap;
}
.customcontain .membercard {
  text-align: left;
  width: 22rem;
}
.selectCSS {
  background-color: #209cee85;
}
.bg {
  background-image: url("../assets/jpg/background2.jpg");
  background-size: 100% 100%;
  height: 100%;
  position: fixed;
  width: 100%;
  top: 0;
}
</style>