import axios from 'axios'

const state = {
    context : "http://localhost:5000/",
    list : [],
    count: 0

}
const actions = {
    async list({commit},data){
        axios.get(state.context + "list/" + data,{
            authorization: "JWT fefege..",
            Accept: "application/json",
            "Content-Type": "application/json"
        })
            .then((data)=>{
                alert("액션 자바 데이터받아옴")
                commit("SEARCH",data)
            })
            .catch(()=>{
                alert("자바 통신실패 액션통신불가")
            })
    }
}
const  mutations = {
    SEARCH(state,data){
    alert("자바에서 넘어온 데이터:" + data)
        state.list = [];
    state.count = data.count;
        data.list.forEach(item => {
            state.list.push({
                seq: item.seq,
                artist: item.artists,
                title: item.title,
                thumbnail: item.thumbnail
            });
        });
    }
}
const  getters = {}

export  default {
    name : 'search',
    namespaced : true,
    actions,
    mutations,
    getters
}