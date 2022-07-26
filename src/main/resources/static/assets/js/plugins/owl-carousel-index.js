function MySlider1__init() {
  $('.my-slider-1 > .owl-carousel').owlCarousel({
    responsive:{
      0:{
        items:3
      }
    },
    loop:true,
    dots:false,
    nav:false,
    center:true
  });
}
MySlider1__init();