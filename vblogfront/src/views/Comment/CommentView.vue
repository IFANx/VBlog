<template>
    <main class="container">
    <div class="row g-5">
        <div class="col-md-12">
            <h3 class="pb-4 mb-4 fst-italic border-bottom">
                From the Firehose
            </h3>

            <article class="blog-post">
                <h2 class="blog-post-title">Sample blog post</h2>
                <p class="blog-post-meta">January 1, 2021 by <a href="#">Mark</a></p>
                <p>This blog post shows a few different types of content that’s supported and styled with Bootstrap. Basic typography, lists, tables, images, code, and more are all supported as expected.</p>
                <hr>
                <p>This is some additional paragraph placeholder content. It has been written to fill the available space and show how a longer snippet of text affects the surrounding content. We'll repeat it often to keep the demonstration flowing, so be on the lookout for this exact same string of text.</p>
                <img src="../../../src/assets/img/3.png">
            </article>
            <div class="position-absolute buttom-0 start-50 translate-middle-x">
                <label for="description" class="form-label" style="font-size: 20px;font-weight:bolder">评论框</label>
                <textarea style="width:1000px" v-model="description" class="form-control" id="description" rows="2"></textarea>
                <button class="btn btn-outline-primary" href="#">提交</button>
            </div>
<!--            <nav class="blog-pagination" aria-label="Pagination">-->
<!--                -->
<!--            </nav>-->

        </div>

    </div>
    </main>
</template>

<script>
  export default {
    name: 'CommentView'
  }
</script>

<style scoped>

</style>
