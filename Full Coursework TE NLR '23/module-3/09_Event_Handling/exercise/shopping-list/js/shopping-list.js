// Initialize variables
let allItemsIncomplete = true;
const pageTitle = 'My Shopping List';
const groceries = [
  { id: 1, name: 'Oatmeal', completed: false },
  { id: 2, name: 'Milk', completed: false },
  { id: 3, name: 'Banana', completed: false },
  { id: 4, name: 'Strawberries', completed: false },
  { id: 5, name: 'Lunch Meat', completed: false },
  { id: 6, name: 'Bread', completed: false },
  { id: 7, name: 'Grapes', completed: false },
  { id: 8, name: 'Steak', completed: false },
  { id: 9, name: 'Salad', completed: false },
  { id: 10, name: 'Tea', completed: false }
];

// Function to set the page title
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;
}

// Function to display groceries in the DOM
function displayGroceries() {
  const ul = document.querySelector('ul');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);
  });
}

// Function to mark an item as complete
function markItemComplete(item) {
  if (!item.classList.contains('completed')) {
    item.classList.add('completed');
    const icon = item.querySelector('i');
    icon.classList.add('completed');
  }
}

// Function to mark an item as incomplete
function markItemIncomplete(item) {
  if (item.classList.contains('completed')) {
    item.classList.remove('completed');
    const icon = item.querySelector('i');
    icon.classList.remove('completed');
  }
}

// Function to toggle all items complete or incomplete
function toggleAll() {
  const items = document.querySelectorAll('li');
  items.forEach((item) => {
    if (allItemsIncomplete) {
      markItemComplete(item);
    } else {
      markItemIncomplete(item);
    }
  });

  allItemsIncomplete = !allItemsIncomplete;

  const toggleButton = document.getElementById('toggleAll');
  toggleButton.textContent = allItemsIncomplete ? 'Mark All Complete' : 'Mark All Incomplete';
}

// Event listener to run on DOMContentLoaded
document.addEventListener('DOMContentLoaded', () => {
  setPageTitle();
  displayGroceries();

  // Add event listeners for each list item to mark them complete or incomplete
  const items = document.querySelectorAll('li');
  items.forEach((item) => {
    item.addEventListener('click', () => {
      markItemComplete(item);
    });

    item.addEventListener('dblclick', () => {
      markItemIncomplete(item);
    });
  });

  // Add event listener for the "Mark All Complete" button to toggle all items
  const toggleButton = document.getElementById('toggleAll');
  toggleButton.addEventListener('click', toggleAll);
});
