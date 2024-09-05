# Module Three Mid-Module Project

## Creating your own Application

If you decide to create your own application, read the Custom Application Requirements below and **please confirm your Application proposal with your instructor.**

### Custom Application Requirements

The following are the minimum requirements your application must include:
* At least 2 [wireframe](https://en.wikipedia.org/wiki/Website_wireframe) sketches or outlines for a single web page, one for desktop and one for mobile, that outlines the page design for both device views
  * You may create the wireframes yourself or use a wireframe template found online or elsewhere
    * If creating your own, [Figma](https://www.figma.com/wireframe-tool/) is one of the most used tools for UX/UI design and wireframing.
  * A wireframe for tablet devices is **optional**
  * Place your wireframes in the `/design` folder
* At least 1 web page (html file) that contains:
  * A header with a logo
    * You can create your own or insert a placeholder image from [Placeholder.com](Placeholder.com)
    * `<img src="https://via.placeholder.com/700x200.jpg">`
  * A footer with copyright text
    * You can decide on the text content
    * Use © or put `&copy;` in the html
  * At least 3 site navigation links
    * It is not required that these link to other pages
  * Styling that utilizes CSS flexbox and/or CSS grid
    * Styles must be in a separate css file that is included in your html file
    * You may use other CSS libraries (bootstrap, tailwind, etc.) to *supplement* your CSS styling
  * No horizontal (left or right) scrolling of the page in the browser window
  * Support for both desktop and mobile views
    * Desktop view is 1024 pixel width or greater
    * Mobile view is 425 pixel width or smaller
  * A display of data generated dynamically from an array containing at least 5 JavaScript objects
    * This must be implemented using JavaScript
      * **Hard-coding JavaScript objects as HTML elements is not permitted**
* A javascript file containing an array of at least 5 JSON objects to display on the web page
  * This javascript file must be included in your html file
  * The array of objects can be hard-coded, sourced from mock data, or from the database of any project you created during the program (see section below)
* At least 3 event listeners and event handlers that respond to user input
  * An event listener for `DOMContentLoaded` can not be used as one of the 3 event listeners
  * Example: a text input field that captures key presses
  * Example: a trash can icon or button that removes a piece of data when clicked
  * Example: a toggle switch that changes your page theme to dark/light mode
* A clear purpose, function, or utility

### Starting Code

Open the Module Three mid-module project `custom` folder in VSCode and review the starting code.

The starting code includes an `index.html`, `style.css` and several `.js` files. The code is provided as a non-functional starting point for you to write your application.  You are free to use or discard any of the provided code.

Files to explore:

#### `index.html`

The `<head>` element links all essential stylesheets and scripts. This part of the file should be altered to provide a `<title>` and icon `<link>` that works for your custom application.

The `<body>` element is empty and is where you will add the html elements for your custom application.

#### `script/resourceService.js`

This script is a template for how you can include data into your custom web application.  `allResources[]` is an array can hold the data for whatever resources that you need to display in your application. You need to read this array and dynamically generate a set of elements from this data. **Note that you must generate the html elements dynamically and MAY NOT hard-code the data directly in the `index.html` file.**

`getResources()` returns the `allResources` array.  

You can add JavaScript objects to the array as the data for your custom application.  For example, if your application displays a list of products, you might add code to the array like the following...

```javascript
const allResources = [
  {
    productId: 1,
    productSku: "MUG-023",
    name: "Coffee mug",
    description: "Start your day off right!",
    price: 14.99,
    imageName: "https://via.placeholder.com/350x250.jpg",
  },
  {
    productId: 2,
    productSku: "HAT-928",
    name: "Baseball cap",
    description: "Look stylish with our logo",
    price: 16.89,
    imageName: "https://via.placeholder.com/350x250.jpg",
  }
  // Add more objects here as needed
];
```

You'll add additional methods to this file that return other resources or subsets of the `allResources` array.

#### `script/app.js`

This file has no content except for an import of the `resourceService.js` file. Use it to:

* Hook up your event handlers.

* Write all methods that define the required behavior of your custom application.

#### `css/style.css`

Another empty file. Use `style.css` to style the application to match your wireframe images.


### Populating the Resources Array with Mock Data

If you use the `allResources` array in your `script/resourceService.js` JavaScript code, the next step is to populate it with mock data. There are several ways to obtain this data, and you are encouraged to choose a method that best suits your project. Below are two suggested approaches:

#### Option 1: Use Data from Your Module-2 Final Project

If you've completed the Module-2 final project, you already have access to a RESTful API that provides various resources. You can use this existing API to populate your array with real data from that project. Here's how you can do it:

1. **Access the API**: Use a tool like [Postman](https://www.postman.com/) to send a GET request to the API endpoint that returns the resource data. 
   
2. **Retrieve JSON Data**: The API will return the data in JSON format. Copy the JSON response that contains the array of objects.

3. **Convert to JavaScript Array**: Paste the JSON data into your JavaScript code and modify it to follow JavaScript syntax. 

#### Option 2: Generate Mock Data with Mockaroo

Alternatively, you can generate mock data tailored to your application using [Mockaroo](https://www.mockaroo.com/). Mockaroo is an online tool that allows you to generate realistic test data in various formats, including JSON.

1. **Visit Mockaroo**: Go to [Mockaroo's website](https://www.mockaroo.com/).

2. **Customize Your Data**: Define the fields and data types you want for your JavaScript objects. Mockaroo offers a wide range of options to create data that closely resembles what you need.

3. **Generate JSON Data**: Once you've set up the schema, generate the data and download it in JSON format.

4. **Convert to JavaScript Array**: Similar to the first option, copy the JSON data and modify it to follow JavaScript syntax. 

#### Summary

By using either of these methods, you can quickly and efficiently populate your array with mock data, allowing you to focus on building and testing your web application's functionality. Choose the approach that best aligns with your project requirements.

---

## Hints

### Currency formatting

If your application uses currency, you can use the `Intl.NumberFormat` object to show it in the proper format. `Intl.NumberFormat` accepts `locale` and `options` as arguments. `locale` specifies the region whose formatting rules you want to use. `options` allows you to specify what type of formatting you want to apply to your number.

For example, to display a value in U.S. Dollars (USD):

```javascript
Intl.NumberFormat(`en-US`, {
        currency: `USD`,
        style: "currency",
    }).format(value);
```

For a more extensive description of the capabilities of `Intl.NumberFormat`, check out [Mozilla's documentation](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Intl/NumberFormat)

### Font Awesome icons

**Font Awesome** is an open source provider of icons, many of which you can use for free.

You must add their kit to your project to use icons from the Font Awesome library. The `index.html` contains a `stylesheet` link to do this:

```html
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" />
```

With the kit installed, you can choose from [thousands of free icons to add to your site](https://fontawesome.com/search?m=free&o=r). Click on an icon in the search page to reveal various options and the HTML needed to display it on your page.

For example, to display an icon of a heart:

<img src="./img/heart-regular.svg" width="50" height="50" />

Add the following tag to your HTML:

```html
<i class="fa-regular fa-heart"></i>
```

Font Awesome offers many other icons, including the magnifying glass and shopping cart used in the wireframe solution.

### Using `setAttribute()` and `getAttribute()`

HTML elements can provide more information in the form of **attributes**. For example, the hard-coded product data gives each `product-name` a `data-id` attribute. Each `data-id` has a unique numeric value:

```html
<div class="product-name action" data-id="1">A super product</div>
```

To set an attribute, call the `setAttribute()` method on the element. It takes two parameters—the name of the attribute to set and the value.

Since each value is unique, you can use your unique resource id to set each `data-id`.  For example:

```javascript
div.setAttribute("data-id", resource.productId);
```

You can retrieve an attribute with `getAttribute()`. This method takes one parameter—the attribute name.

You can get the `data-id` to identify which `product-name` the user clicked using the `getAttribute()` method:

```javascript
// Get the id of the event target
const id = Number(event.currentTarget.getAttribute("data-id"));
```
