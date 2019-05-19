<template>
  <div>
    <div class="bg"></div>
    <div class="nes-container with-title is-centered" style="margin:5%;backgroundColor:#fff;">
      <span class="title" style="fontSize:3rem;color:#92cc41;">☆ 可取用物资 ☆</span>
      <!-- 如果是通过查看订单详情进来的，就显示订单编号，如果从用户创建订单进来的就显示new order（默认值），如果是首页进来的就不显示 -->
      <div
        class="is-size-1"
        style="color:#209cee;textAlign:left;marginBottom:1rem;"
        v-show="showFlag"
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
      <!-- 从订单列表进来的都不显示物资修改框 -->
      <div class="nes-container with-title" style="marginBottom:1rem;" v-show="!showFlag">
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
      <!-- 如果是新建就展示用户信息，如果从订单列表进来就不显示，因为这时候已经锁定用户姓名了 -->
      <div class="nes-container with-title" style="marginBottom:1rem;" v-show="!showFlag">
        <span class="title" style="color:#209cee;fontSize:2rem;">用户信息</span>
        <div style="margin:10px;">
          <span style="fontSize:2rem;">姓名：</span>
          <input type="text" class="nes-input is-size-3" style="width:90%;" v-model="userName">
        </div>
      </div>
      <div
        class="nes-btn is-size-1 is-success"
        style="width:100%;marginBottom:1rem;"
        @click="save"
        v-show="saveBtn"
      >保存</div>
      <!-- 当用户被删除，他的订单就不支持更新了，只能查看或删除（隐藏保存按钮，释出删除按钮） -->
      <div
        class="nes-btn is-size-1 is-error"
        style="width:100%;marginBottom:1rem;"
        @click="expireDel"
        v-show="!saveBtn"
      >删除</div>
      <div class="nes-btn is-size-1" style="width:100%;" @click="routerBack">返回</div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      allItems: this.$storage.get("allItems"),
      // 储存物资数量
      itemCount: [],
      orderId: "New Order",
      showFlag: false,
      itemInfo: {
        itemName: "请输入物资名称",
        itemPrice: "请输入物资价格（单位：元）",
        itemDetail: "请输入物资描述"
      },
      summitUrl: "/addItem",
      userName: "请输入用户姓名",
      saveBtn: true
    };
  },
  mounted() {
    // 加载时判断有没有物资列表,有就渲染出来
    let arrTemp = this.$route.params.detailList;
    // 设置判断表示,避免循环里边多次判断
    let judgeFlag = false;
    if (typeof arrTemp != "undefined" && arrTemp.length != 0) {
      judgeFlag = true;
    }
    for (let index = 0; index < this.allItems.length; index++) {
      this.itemCount.push(0);
      // 默认传0,如果有物资列表就传对应值
      if (judgeFlag) {
        arrTemp.forEach(element => {
          if (this.allItems[index].itemId == element.detailItemid) {
            this.itemCount[index] = element.detailItemnum;
          }
        });
      }
    }
    //这里跟上面的要分开，用以兼容选定用户新增订单的情况
    if (this.$route.params.userName > 0) {
      // 这个this.username的赋值是为了做删除按钮的标识
      this.$storage.get("allUsers").forEach(element => {
        if (element.userId == this.$route.params.userName) {
          this.userName = element.userName;
        }
      });
      if (this.$route.params.orderId > 0) {
        this.orderId = this.$route.params.orderId;
      }
      this.showFlag = true;
    }
    if (typeof this.orderId == "number" && this.userName == "请输入用户姓名") {
      this.saveBtn = false;
    }
  },
  methods: {
    routerBack() {
      this.$router.push("/");
    },
    // 加法要把类型转一下，不然会变成字符串拼接
    additonCount(index) {
      this.$set(this.itemCount, index, parseInt(this.itemCount[index]) + 1);
    },
    // 物资数量减法
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
    // 通过递归实现物资详情信息批量处理
    forAjax(params) {
      // 如果没有选中任何物资，就直接删除订单，因为前面已经清空过一次物资详情了
      if (params.length < 1) {
        let url = "/deleteorder/" + this.orderId;
        this.$ajax.post(url).then(res => {
          if (res.data == 1) {
            console.log("取消订单创建");
          }
          this.$router.push("/");
        });
        return;
      }
      // 提取入参中的物资详情
      let paramsTemp = {
        detailOrderid: params[0]["detailOrderid"],
        detailItemid: params[0]["itemId"],
        detailItemnum: params[0]["itemCount"]
      };
      this.$ajax.post("/addorderdetail", paramsTemp).then(response => {
        if (response.data == 1) {
          console.log("成功为订单插入一条物资详情");
        }
        // 发送一次就砍一次数组长度，没有可用的就拦截跳出来
        params.shift();
        if (params.length == 0) {
          this.$router.push("/");
          return;
        }
        // 没有被拦截就继续递归传输
        this.forAjax(params);
      });
    },
    // 生成数量不为零详情数组，用以更新订单详情，注意只有对象可以被处理，传变量其值是不会有变化的
    getItemCount(arrAjax, orderId) {
      for (let index = 0; index < this.allItems.length; index++) {
        let arrAjax2 = {};
        if (this.itemCount[index] != 0) {
          arrAjax2["itemId"] = this.allItems[index].itemId;
          arrAjax2["itemCount"] = this.itemCount[index];
          arrAjax2["detailOrderid"] = orderId;
          arrAjax.push(arrAjax2);
        }
      }
    },
    // 计算订单中物资总数，用以创建订单
    sumCount(params) {
      for (let index = 0; index < this.allItems.length; index++) {
        params.orderNote +=
          this.allItems[index].itemPrice * this.itemCount[index];
        params.orderGoodscount += parseInt(this.itemCount[index]);
      }
    },
    // 新增/更新物资
    upgrateItems() {
      // 这里要给每个字段设置第二个默认值用于传参的，懒得做就先这样了
      if (this.itemInfo.itemPrice == "请输入物资价格（单位：元）") {
        this.itemInfo.itemPrice = 0 ;
      }else{
        this.itemInfo.itemPrice == parseFloat(this.itemInfo.itemPrice);
      }
      // 物资名匹配，存在就更新，不存在就新增
      this.allItems.forEach(element => {
        if (element.itemName == this.itemInfo.itemName) {
          this.summitUrl = "/updateItem";
          this.itemInfo["itemId"] = element["itemId"];
          return false;
        }
      });
      this.$ajax.post(this.summitUrl, this.itemInfo).then(response => {
        if (response.data == 1) {
          console.log("更新物资信息成功");
        } else {
          console.log("更新物资信息失败");
        }
        this.reflash();
      });
    },
    // 删除物资
    deleteItem() {
      this.allItems.forEach(element => {
        if (element.itemName == this.itemInfo.itemName) {
          this.summitUrl = "/delitem/" + element["itemId"];
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
    // 从首页进来创建订单
    creatOrder() {
      // 要先创建用户
      let userTemp = { userName: this.userName };
      this.$ajax.post("/addUser", userTemp).then(response => {
        let orderTemp = {
          orderNote: 0,
          orderGoodscount: 0
        };
        this.sumCount(orderTemp);
        orderTemp["orderUserid"] = response.data;
        // 再创建订单
        this.$ajax.post("/addorder", orderTemp).then(response => {
          this.orderId = response.data;
          let arrAjax = [];
          this.getItemCount(arrAjax, response.data);
          // 在插入详情
          this.forAjax(arrAjax);
        });
      });
    },
    // 从指定用户订单列表页进来创建订单
    creatUserOrder() {
      let params = {
        orderUserid: this.$route.params.userName,
        orderNote: 0,
        orderGoodscount: 0
      };
      this.sumCount(params);
      // 直接根据用户id创建订单
      this.$ajax.post("/addorder", params).then(response => {
        this.orderId = response.data;
        let arrAjax = [];
        this.getItemCount(arrAjax, response.data);
        // 插入详情
        this.forAjax(arrAjax);
      });
    },
    // 从订单详情页进来修改订单
    updateUserOrder() {
      // 先直接清空此订单原有物资详情，然后后面统一新增，不然又新增又更新有点麻烦
      let url = "/delorderdetail/" + this.orderId;
      this.$ajax.get(url).then(response => {
        if (response == 1) {
          console.log('开始更新订单信息');
        }
        let params = {
          orderUserid: this.$route.params.userName,
          orderId: this.orderId,
          orderNote: 0,
          orderGoodscount: 0
        };
        this.sumCount(params);
        // 更新用户消息
        this.$ajax.post("/updateorder", params).then(response => {
          if (response == 1) {
            console.log('订单信息更新成功');
          }
          // 这里都是创建临时变量，因为直接调全局变量来处理好像会报错
          let arrAjax = [];
          this.getItemCount(arrAjax, this.orderId);
          this.forAjax(arrAjax);
        });
      });
    },
    // 条件方法，根据不同情况，实现不同的订单更新/创建
    save() {
      if (typeof this.orderId == "number") {
        this.updateUserOrder();
      } else if (!this.showFlag) {
        this.creatOrder();
      } else {
        this.creatUserOrder();
      }
    },
    // 删除过期订单（就是他的用户被删除了，我们就允许它更新，只能看看或删掉）
    expireDel() {
      let url = "/deleteorder/" + this.orderId;
      let urlDetail = "/delorderdetail/" + this.orderId;
      this.$ajax.post(url).then(res => {
        if (res.data == 1) {
          console.log("成功删除过期订单");
        }
        this.$ajax.post(urlDetail).then(res => {
          if (res.data > 0) {
            console.log("成功删除过期订单详情");
          }
          this.$router.push("/");
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