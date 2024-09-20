<template>
    <div id="details">
        <section id="title">
            <h2 id="title">{{recipe.label}}</h2>
            <a v-on:click="toggleImage">({{showImageText}} image)</a>
            <img v-show="showImage" v-bind:src="getImageSrc" />
        </section>
        <section id="info">
            <p>Yield: {{recipe.yield }}</p>
            <p>Calories per serving: {{ caloriesPerServing }}</p>
            <h3>Source:</h3>
            <p>{{recipe.source}}</p>
            <h3>Instructions:</h3>
            <a class="title-btn" v-bind:href="recipe.url" target="_blank">Visit {{recipe.source}}</a>
        </section>
        <section id="ingredients">
            <h3>Ingredients</h3>
            <div id="unit-btns">
                <button class="title-btn" v-on:click="listImperialUnits"
                    v-bind:disabled="ingredientUnit == 'imperial'">Imperial</button>
                <button class="title-btn" v-on:click="listMetricUnits"
                    v-bind:disabled="ingredientUnit == 'metric'">Metric</button>
            </div>
            <ul>
                <li v-for="ingredient,index in recipe.ingredients" v-bind:ingredient="ingredient"
                    v-bind:key="index">
                    {{ ingredient[ingredientUnit] }}
                </li>
            </ul>
        </section>
    </div>
</template>

<script>
import recipeData from "../assets/RecipeData";


export default {
    data() {
        return {
            recipe: recipeData.getRecipeData(),
            showImage: true,
            ingredientUnit: "imperial",
        }
    },
    computed: {
        getImageSrc() {
            const imgUrl = `/src/assets/${this.recipe.image}`
            return new URL(imgUrl, import.meta.url);
        },
        showImageText() {
            return this.showImage ? 'hide' : 'show';
        },
        caloriesPerServing() {
            return this.recipe.totalCalories / this.recipe.yield;
        }
    },
    methods: {
        toggleImage() {
            this.showImage = !this.showImage;
        },
        listImperialUnits() {
            this.ingredientUnit = "imperial";
        },
        listMetricUnits() {
            this.ingredientUnit = "metric";
        }
    }
}
</script>

<style scoped>
#details {
    text-align: left;
    display: grid;
    grid-template-columns: 1fr 2fr;
    grid-template-areas:
        "title title"
        "img img"
        "info ingredients";
}

#unit {
    display: flex;
}

img {
    grid-area: img;
    max-height: 1050px;
    max-width: 100%;
}

#title {
    text-align: center;
    grid-area: title;
}

#title h2 {
    display: inline-block;
    margin-right: 8px;
}

#info {
    grid-area: info;
}

#ingredients {
    grid-area: ingredients;
}

#ingredients h3 {
    text-align: center;
}

#unit-btns {
    display: flex;
    justify-content: center;
}
</style>