<template>
  <div>
    <h1>{{ card.title }}</h1>
    <p> {{ card.description }} </p>
    <div class="loading" v-if="isLoading">
      <img src="../assets/loading.gif" />
    </div>
    <comments-list v-bind:comments="card.comments" v-show="!isLoading"/>
    <!-- OR -->
    <!-- <comments-list v-bind:comments="card.comments" v-else /> -->

    <div class="board-actions" v-show="!isLoading">
      <router-link v-bind:to="{ name: 'Board', params: {id: $route.params.boardID}}">Back to Board</router-link>
    </div>

  </div>
</template>

<script>
import boardService from '../services/BoardService';
import CommentsList from '../components/CommentsList.vue';
export default {
  name: "card-detail",
  components:{
    CommentsList
  },

  data(){
    return {
      card: {
        title: '',
        description: '',
        status: '',
        comments: []
      },
      isLoading: true
    };
  },
  //Vue Lifecycle Hook
  created() {
    boardService
      .getCard(this.$route.params.boardID, this.$route.params.cardID)
      .then(response => {
        this.card = response;
        this.isLoading = false;
      });


  }


};
</script>
