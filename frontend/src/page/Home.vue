<template>
    <div>
        <div class="nes-container">
            <div>天河游击士协会狩魔登记系统</div>
            <div>
                <span class="nes-text is-warning">黄色</span>
                <span class="nes-text is-error">橙色</span>
                <span class="nes-text is-disabled">灰色</span>
            </div>
        </div>
        <div class="columns">
            <div class="column">
                <div class="nes-btn" @click="testBtn">白色</div>
            </div>
            <div class="column">
                <div class="nes-btn is-primary"  @click="testBtn2">蓝色</div>
            </div>
            <div class="column">
                <div class="nes-btn is-success">绿色</div>
            </div>
            <div class="column">
                <div class="nes-btn is-error">绿色</div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    methods: {
        
        testBtn(){
            this.$ajax.get("/findAllUser").then(response => {
                console.log(response.data);
                this.$storage.set("testTTT",response.data)
                });
        },
        testBtn2(){
            let bbb = this.$storage.get("testTTT");
            console.log(bbb);
            
        }
    }
}
</script>
<style scope>
@import "//unpkg.com/nes.css@latest/css/nes.min.css";
@import "../assets/css/bulma.css";

div {
    font-family: "JfDotMPlus";
}
</style>