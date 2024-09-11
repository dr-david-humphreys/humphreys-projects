import { resourceService } from "./resourceService.js";

document.addEventListener('DOMContentLoaded', () => {
    const resources = getResources();
    const container = document.getElementById('resource-container');

    resources.forEach(resource => {
        const div = document.createElement('div');
        div.innerHTML = `<h3>${resource.title}</h3><p>${resource.description}</p>`;
        container.appendChild(div);
    });
});