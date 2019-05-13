<template>
    <div>
        <div class="nes-container with-title is-centered" style="margin:5%;">
            <span class="title" style="fontSize:3rem;color:#92cc41;">☆ 可取用物资 ☆</span>
            <!-- 如果是修改订单就展示 -->
            <div class="is-size-1" style="color:#209cee;textAlign:left;marginBottom:1rem;">订单编号: {{orderId}}</div>
            <div class="nes-container" v-for="(item,index) in allItems" :key="index" style="marginBottom:1rem;" :class="{rowSelect:itemCount[index]!=0}">
                <div style="display:flex;justify-content:space-between;align-items:center">
                    <div class="itemCss" style="fontWeight:bold;">{{item.itemName}}</div>
                    <div class="itemCss">{{item.itemDetail}}</div>
                    <div class="itemCss" style="textAlign:center;color:#e76e55;">￥{{item.itemPrice}}</div>
                    <div style="display:flex;justify-content:space-between;">
                        <div class="nes-btn is-size-1 is-warning" style="width:5rem" @click="subtractionCount(index)">-</div>
                        <input type="text" class="nes-input inputCss" v-model="itemCount[index]">
                        <div class="nes-btn is-size-1 is-warning" style="width:5rem" @click="additonCount(index)">+</div>
                    </div>
                </div>
            </div>
            <!-- 是修改订单就不显示物资变更 -->
            <div class="nes-container with-title" style="marginBottom:1rem;">
                <span class="title" style="color:#e76e55;fontSize:2rem;">物资变更</span>
                <div style="margin:10px;"><span style="fontSize:2rem;">名称：</span><input type="text" class="nes-input" style="width:90%;"></div>
                <div style="margin:10px;"><span style="fontSize:2rem;">描述：</span><input type="text" class="nes-input" style="width:90%;"></div>
                <div style="margin:10px;"><span style="fontSize:2rem;">价格：</span><input type="text" class="nes-input" style="width:90%;"></div>
                <div style="display:flex;justify-content:space-between;margin:1rem;">
                    <div class="nes-btn is-size-1 is-primary" style="width:40rem">新增/修改</div>
                    <div class="nes-btn is-size-1 is-error" style="width:40rem">删除</div>
                </div>
            </div>
            <!-- 是修改订单就不显示用户信息 -->
            <!-- 如果是新建就展示用户信息 -->
            <div class="nes-container with-title" style="marginBottom:1rem;">
                <span class="title" style="color:#209cee;fontSize:2rem;">用户信息</span>
                <div style="margin:10px;"><span style="fontSize:2rem;">姓名：</span><input type="text" class="nes-input" style="width:90%;"></div>
            </div>
            <div class="nes-btn is-size-1 is-success" style="width:100%;marginBottom:1rem;" @click="routerBack">保存</div>
            <div class="nes-btn is-size-1" style="width:100%;" @click="routerBack">返回</div>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            allItems:[],
            itemCount:[],
            orderId:'2',
        }
    },
    mounted() {
        this.allItems = this.$storage.get("allItems");
        for (let index = 0; index < this.allItems.length; index++) {
            this.itemCount.push(0);
        }
    },
    methods: {
        routerBack(){
            this.$router.push("/")
        },
        additonCount(index){
            this.$set(this.itemCount,index,this.itemCount[index]+1)
        },
        subtractionCount(index){
            this.$set(this.itemCount,index,this.itemCount[index]-1)
        },       
    },
}
</script>
<style scope>
    .itemCss{
        width: 10rem;
        text-align: left;
        font-size: 2rem;
    }
    .inputCss{
        margin-left: 1rem;
        margin-right: 1rem;
        width: 5rem;
        text-align: center;
        font-size: 2rem;
    }
    .rowSelect{
        background-color:#92cc4185;
    }
</style>