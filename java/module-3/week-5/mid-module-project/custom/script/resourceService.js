const allResources = [
  // add objects to represent your custom application resources here

  { id: 1, title: "Item 1", description: "Description for Item 1"},
  { id: 2, title: "Item 2", description: "Description for Item 2"},
  { id: 3, title: "Item 3", description: "Description for Item 3"},
  { id: 4, title: "Item 4", description: "Description for Item 4"},
  { id: 5, title: "Item 5", description: "Description for Item 5"}
];

const resourceService = {
  getResources() {
    return allResources;
  }
};

export { resourceService };
