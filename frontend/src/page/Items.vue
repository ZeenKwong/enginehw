<template>
  <div>
    <div class="bg"></div>

    <div class="nes-container with-title is-centered" style="margin:5%;backgroundColor:#fff;">
      <span class="title" style="fontSize:3rem;color:#92cc41;">☆ 可取用物资 ☆</span>
      <!-- 如果是修改订单就展示 -->
      <div
        class="is-size-1"
        style="color:#209cee;textAlign:left;marginBottom:1rem;"
        :style="{display:orderIdFlag}"
      >订单编号: {{orderId}}</div>
      <div
        class="nes-container"
        v-for="(item,index) in allItems"
        :key="index"
        style="marginBottom:1rem;"
        :class="{rowSelect:itemCount[index]!=0}"
      >
        <div style="display:flex;justify-content:space-between;align-items:center">
          <div class="itemCss" style="fontWeight:bold;">{{item.itemName}}</div>
          <div class="itemCss">{{item.itemDetail}}</div>
          <div class="itemCss" style="textAlign:center;color:#e76e55;">￥{{item.itemPrice}}</div>
          <div style="display:flex;justify-content:space-between;">
            <div
              class="nes-btn is-size-1 is-warning"
              style="width:5rem"
              @click="subtractionCount(index)"
            >-</div>
            <input type="text" class="nes-input inputCss" v-model="itemCount[index]">
            <div
              class="nes-btn is-size-1 is-warning"
              style="width:5rem"
              @click="additonCount(index)"
            >+</div>
          </div>
        </div>
      </div>
      <!-- 是修改订单就不显示物资变更 -->
      <div
        class="nes-container with-title"
        style="marginBottom:1rem;"
        :style="{display:itemInfoFlag}"
      >
        <span class="title" style="color:#e76e55;fontSize:2rem;">物资变更</span>
        <div style="margin:10px;">
          <span style="fontSize:2rem;">名称：</span>
          <input type="text" class="nes-input" style="width:90%;" v-model="itemInfo.itemName">
        </div>
        <div style="margin:10px;">
          <span style="fontSize:2rem;">描述：</span>
          <input type="text" class="nes-input" style="width:90%;" v-model="itemInfo.itemDetail">
        </div>
        <div style="margin:10px;">
          <span style="fontSize:2rem;">价格：</span>
          <input type="text" class="nes-input" style="width:90%;" v-model="itemInfo.itemPrice">
        </div>
        <div style="display:flex;justify-content:space-between;margin:1rem;">
          <div class="nes-btn is-size-1 is-primary" style="width:40rem" @click="upgrateItems">新增/修改</div>
          <div class="nes-btn is-size-1 is-error" style="width:40rem" @click="deleteItem">删除</div>
        </div>
      </div>
      <!-- 是修改订单就不显示用户信息 -->
      <!-- 如果是新建就展示用户信息 -->
      <div class="nes-container with-title" style="marginBottom:1rem;">
        <span class="title" style="color:#209cee;fontSize:2rem;">用户信息</span>
        <div style="margin:10px;">
          <span style="fontSize:2rem;">姓名：</span>
          <input type="text" class="nes-input" style="width:90%;" v-model="userName">
        </div>
      </div>
      <div
        class="nes-btn is-size-1 is-success"
        style="width:100%;marginBottom:1rem;"
        @click="creatOrder"
      >保存</div>
      <div class="nes-btn is-size-1" style="width:100%;" @click="routerBack">返回</div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      allItems: this.$storage.get("allItems"),
      itemCount: [],
      orderId: "2",
      orderIdFlag: "none",
      itemInfo: {
        itemName: "请输入物资名称",
        itemPrice: "请输入物资价格（单位：元）",
        itemDetail: "请输入物资描述"
      },
      summitUrl: "/addItem",
      userName: this.$route.params.userName || "请填写用户姓名",
      itemInfoFlag: this.$route.params.itemInfoFlag || "show",
      detailTemp: {
        detailOrderid: 0,
        detailItemid: 0,
        detailItemnum: ""
      }
    };
  },
  mounted() {
    let arrTemp = this.$route.params.detailList;
    let judgeFlag = false;
    if (typeof arrTemp != "undefined" && arrTemp.length != 0) {
      judgeFlag = true;
    }
    for (let index = 0; index < this.allItems.length; index++) {
      this.itemCount.push(0);

      if (judgeFlag) {
        arrTemp.forEach(element => {
          if (this.allItems[index].itemId == element.detailItemid) {
            this.itemCount[index] = element.detailItemnum;
          }
        });
      }
    }
    console.log(this.itemCount);
    
  },
  methods: {
    routerBack() {
      this.$router.push("/");
    },
    additonCount(index) {
      this.$set(this.itemCount, index, this.itemCount[index] + 1);
    },
    subtractionCount(index) {
      this.$set(this.itemCount, index, this.itemCount[index] - 1);
    },
    reflash() {
      this.$ajax.get("/finditem/0").then(response => {
        this.allItems = response.data;
        this.$storage.set("allItems", response.data);
        this.summitUrl = "/addItem";
        this.itemCount = [];
        for (let index = 0; index < this.allItems.length; index++) {
          this.itemCount.push(0);
        }
        for (let key in this.itemInfo) {
          this.itemInfo[key] = null;
        }
      });
    },
    upgrateItems() {
      this.itemCount.itemPrice = parseInt(this.itemInfo.itemPrice);
      this.allItems.forEach(element => {
        if (element.itemName == this.itemInfo.itemName) {
          this.summitUrl = "/updateItem";
          this.itemInfo["itemId"] = element["itemId"];
          return false;
        }
      });
      this.$ajax.post(this.summitUrl, this.itemInfo).then(response => {
        if (response.data == 1) {
          console.log("更新成功");
        } else {
          console.log("更新失败");
        }
        this.reflash();
      });
    },
    deleteItem() {
      this.allItems.forEach(element => {
        if (element.itemName == this.itemInfo.itemName) {
          this.summitUrl = "/delitem/" + element["itemId"];
          console.log(this.summitUrl);
          return false;
        }
      });
      this.$ajax.post(this.summitUrl).then(response => {
        if (response.data == 1) {
          console.log("删除成功");
        } else {
          console.log("删除失败");
        }
        this.reflash();
      });
    },
    forAjax(params) {
      let paramsTemp = {
        detailOrderid: params[0]["detailOrderid"],
        detailItemid: params[0]["itemId"],
        detailItemnum: params[0]["itemCount"]
      };
      this.$ajax.post("/addorderdetail", paramsTemp).then(response => {
        console.log(response);

        params.shift();
        if (params.length == 0) {
          return;
        }
        this.forAjax(params);
      });
    },
    creatOrder() {
      let userTemp = { userName: this.userName };
      this.$ajax.post("/addUser", userTemp).then(response => {
        let orderTemp = {};
        for (let index = 0; index < this.allItems.length; index++) {
          orderTemp["orderNote"] +=
            this.allItems[index].itemPrice * this.itemCount[index];
          orderTemp["orderGoodscount"] += this.itemCount[index];
        }
        orderTemp["orderUserid"] = response.data;
        this.$ajax.post("/addorder", orderTemp).then(response => {
          let arrAjax = [];
          for (let index = 0; index < this.allItems.length; index++) {
            let arrAjax2 = {};
            if (this.itemCount[index] != 0) {
              arrAjax2["itemId"] = this.allItems[index].itemId;
              arrAjax2["itemCount"] = this.itemCount[index];
              arrAjax2["detailOrderid"] = response.data;
              arrAjax.push(arrAjax2);
            }
          }
          this.forAjax(arrAjax);
        });
      });
    }
  }
};
</script>
<style scope>
.itemCss {
  width: 10rem;
  text-align: left;
  font-size: 2rem;
}
.inputCss {
  margin-left: 1rem;
  margin-right: 1rem;
  width: 5rem;
  text-align: center;
  font-size: 2rem;
}
.rowSelect {
  background-color: #92cc4185;
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