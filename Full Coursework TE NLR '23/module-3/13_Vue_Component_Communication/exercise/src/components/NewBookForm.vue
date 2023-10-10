<template>
  <form class="new-book-form" @submit.prevent="addNewBook">
    <label for="title">Title:</label>
    <input v-model="title" class="title-input" required />

    <label for="author">Author:</label>
    <input v-model="author" class="author-input" required />

    <label for="isbn">ISBN:</label>
    <input v-model="isbn" class="isbn-input" required />

    <button type="submit">Add Book</button>
  </form>
</template>

<script>
export default {
  name: "new-book-form",
  data() {
    return {
      title: "",
      author: "",
      isbn: "",
    };
  },
  methods: {
    addNewBook() {
      this.$store.commit("addBook", {
        title: this.title,
        author: this.author,
        read: false,
        isbn: this.isbn,
      });

      // Clear form fields after adding the book
      this.title = "";
      this.author = "";
      this.isbn = "";
    },
  },
};
</script>

<style>
/* Add your CSS styles for the NewBookForm here */
.new-book-form {
  display: flex;
  flex-direction: column;
  max-width: 300px;
  margin: 20px;
}

.new-book-form label {
  font-weight: bold;
  margin-top: 10px;
}

.new-book-form input {
  padding: 5px;
  margin-bottom: 10px;
}

.new-book-form button {
  padding: 8px 16px;
  background-color: #007bff;
  color: #fff;
  border: none;
  cursor: pointer;
}

.new-book-form button:hover {
  background-color: #0056b3;
}
</style>