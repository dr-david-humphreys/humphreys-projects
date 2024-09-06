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

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector('ul');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);

    li.addEventListener('click', function() {
      markItemComplete(li, checkCircle);
    });

    li.addEventListener('dblclick', function() {
      markItemIncomplete(li, checkCircle);
    });

    ul.appendChild(li);
  });
}

function markItemComplete(listItem, icon) {
  if (!listItem.classList.contains('completed')) {
    listItem.classList.add('completed');
    icon.classList.add('completed');
  }
}

function markItemIncomplete(listItem, icon) {
  if (listItem.classList.contains('completed')) {
    listItem.classList.remove('completed');
    icon.classList.remove('completed');
  }
}

function toggleAllItems() {
  const listItems = document.querySelectorAll('li');
  const checkCircles = document.querySelectorAll('i');

  if (allItemsIncomplete) {
    listItems.forEach((listItem, index) => {
      listItem.classList.add('completed');
      checkCircles[index].classList.add('completed');
    });
    document.getElementById('toggleAll').innerText = 'Mark All Incomplete';
  } else {
    listItems.forEach((listItem, index) => {
      listItem.classList.remove('completed');
      checkCircles[index].classList.remove('completed');
    });
    document.getElementById('toggleAll').innerText = 'Mark All Complete';
  }

  allItemsIncomplete = !allItemsIncomplete;
}

document.addEventListener('DOMContentLoaded', () => {
  setPageTitle();
  displayGroceries();

  const toggleButton = document.getElementById('toggleAll');
  toggleButton.addEventListener('click', toggleAllItems);
});