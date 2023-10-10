<template>
  <div :class="['card', { 'read': book.read }]">
    <h2 class="book-title">
         {{ book.title }} 
    </h2>
    <img class="book-image" v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <h3 class="book-author"> {{ book.author }}</h3>
     <div class="button-container" v-if="! enableAdd">
      <button class="mark-read" @click.prevent="setRead(true)" v-if="!book.read">Mark Read</button>
      <button class="mark-unread" @click.prevent="setRead(false)" v-if="book.read">Mark Unread</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "book-card",
  props: {
    book: {
      type: Object,
      required: true,
    },
  },
  methods: {
     setRead(readStatus) {
      // Call the Vuex store mutation to update the book's read status
      if (readStatus) {
        this.$store.commit("Mark Read", this.book.isbn);
      } else {
        this.$store.commit("Mark Unread", this.book.isbn);
      }
    },
  },
};
</script>


<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
    position: relative;
}

.card.read {
    background-color: lightgray;
}

.card .book-title {
    font-size: 1.5rem;
}

.card .book-author {
    font-size: 1rem;
}

.book-image {
    width: 80%;
}


.mark-read, .mark-unread {
    display: block;
    position: absolute;
    bottom: 40px;
    width: 80%;
    left: 10%;
    font-size: 1rem;
}
</style>