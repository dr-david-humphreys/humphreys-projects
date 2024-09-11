const allResources = [
  // add objects to represent your custom application resources here

  { id: 1, practiceSessionNumber: "Practice Session 1", goal: "Goal for Practice Session 1" },
  { id: 2, practiceSessionNumber: "Practice Session 2", goal: "Goal for Practice Session 2" },
  { id: 3, practiceSessionNumber: "Practice Session 3", goal: "Goal for Practice Session 3" },
  { id: 4, practiceSessionNumber: "Practice Session 4", goal: "Goal for Practice Session 4" },
  { id: 5, practiceSessionNumber: "Practice Session 5", goal: "Goal for Practice Session 5" }
];

const resourceService = {
  getResources() {
    return allResources;
  }
};

export { resourceService };
