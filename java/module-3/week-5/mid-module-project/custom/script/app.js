import { resourceService } from "./resourceService.js";

document.addEventListener('DOMContentLoaded', () => {
    const resources = resourceService.getResources();
    const container = document.getElementById('resource-container');

    resources.forEach(resource => {
        const div = document.createElement('div');
        div.innerHTML = `<h3>${resource.title}</h3><p>${resource.description}</p>`;
        container.appendChild(div);
    });

    document.getElementById('myButton').addEventListener('click', () => {
        alert('Button clicked!');
    });

    const body = document.body;
    document.getElementById('themeToggle').addEventListener('click', () => {
        body.classList.toggle('dark-mode');
    });

    document.getElementById('removeItem').addEventListener('click', () => {
        const container = document.getElementById('resource-container');
        if (container.lastChild) {
            container.removeChild(container.lastChild);
        }
    });

    const addPracticeSessionForm = document.getElementById('addPracticeSessionForm');
    addPracticeSessionForm.addEventListener('submit', (event) => {
        event.preventDefault();

        const practiceSessionNumber = document.getElementById('practiceSessionNumber').value;
        const goal = document.getElementById('goal').value;

        const newResource = { id: resources.length + 1, practiceSessionNumber, goal };

        resources.push(newResource);
        displayResource(newResource);
        addItemForm.reset();
    });
});