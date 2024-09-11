const allResources = [
  // add objects to represent your custom application resources here

  { id: 1, title: "Practice Session 1", description: "Goal for Practice Session 1"},
  { id: 2, title: "Practice Session 2", description: "Goal for Practice Session 2"},
  { id: 3, title: "Practice Session 3", description: "Goal for Practice Session 3"},
  { id: 4, title: "Practice Session 4", description: "Goal for Practice Session 4"},
  { id: 5, title: "Practice Session 5", description: "Goal for Practice Session 5"}
];

const resourceService = {
  getResources() {
    return allResources;
  }
};

export { resourceService };
