// js Document

  // Project:        SOTTO - Blog and Portfolio HTML Template.
  // Version:        1.0
  // Last change:    16/05/2018.
  // Designed:       heloshape (http://heloshape.com/)
  // Developed:      heloshape (http://heloshape.com/)


(function($) {
    "use strict";
    
    
    $(document).ready(function(){
        
        // -------------------- Navigation Scroll
        $(window).scroll(function() {    
          var sticky = $('.theme-main-header'),
          scroll = $(window).scrollTop();
          if (scroll >= 190) sticky.addClass('fixed');
          else sticky.removeClass('fixed');

        });


        
        // -------------------- Remove Placeholder When Focus Or Click
        $("input,textarea").each( function(){
            $(this).data('holder',$(this).attr('placeholder'));
            $(this).on('focusin', function() {
                $(this).attr('placeholder','');
            });
            $(this).on('focusout', function() {
                $(this).attr('placeholder',$(this).data('holder'));
            });     
        });
        
        // -------------------- From Bottom to Top Button
            //Check to see if the window is top if not then display button
        $(window).on('scroll', function (){
          if ($(this).scrollTop() > 200) {
            $('.scroll-top').fadeIn();
          } else {
            $('.scroll-top').fadeOut();
          }
        });
            //Click event to scroll to top
        $('.scroll-top').on('click', function() {
          $('html, body').animate({scrollTop : 0},1500);
          return false;
        });


        // ---------------------------- Greeting Message
        var thehours = new Date().getHours();
        var themessage;
        var morning = ('Good morning');
        var afternoon = ('Good afternoon');
        var evening = ('Good evening');

        if (thehours >= 0 && thehours < 12) {
          themessage = morning; 

        } else if (thehours >= 12 && thehours < 17) {
          themessage = afternoon;

        } else if (thehours >= 17 && thehours < 24) {
          themessage = evening;
        }
        $('.greeting').append(themessage);



        // --------------------------------- Search Box
        var search = $("#search-button"),
        mainSearch = $("#searchWrapper"),
        close = $("#close-button");
        if(search.length) {
          search.on('click', function(){
            mainSearch.addClass('show-box');
            $(".main-page-wrapper").addClass('blury-bg')
          });
          close.on('click', function() {
            mainSearch.removeClass('show-box');
            $(".main-page-wrapper").removeClass('blury-bg')
          });
        }


        // ---------------------------- Style Switcher
        var switcher = $('.switch-menu');
        if (switcher.length) {
            $('.switch-btn button').on('click', function(){
              $('.switcher').toggleClass('switcher-show')
            });

            $('#styleOptions').styleSwitcher({
              hasPreview: true,
                fullPath: 'css/',
                 cookie: {
                  expires: 40000,
                  isManagingLoad: true
              }
            });
          };


        // ------------------------ Breaking News Ticker
        var tickerWrapper = $ (".easyTicker");
        if(tickerWrapper.length) {
          tickerWrapper.easyTicker({
            direction: 'up',
            easing: 'easeInOutCirc',
            speed: 'slow',
            interval: 3000,
            height: 'auto',
            visible: 1,
            mousePause: 1,
          });
        }


        // ------------------------------ Theme Menu 
        var menu= $("#mega-menu-holder");
          if(menu.length) {
            menu.slimmenu({
              resizeWidth: '767',
              animSpeed:'medium',
              indentChildren: true,
            });
          }


          // ------------------------------ Video Blog 
          var embed = $ (".embed-video");
            if (embed.length) {
              embed.fitVids();
            }

        // --------------------------- Theme Main Banner Slider One
        
        if($("#main-slider-one").length) {
          var masterslider = new MasterSlider();

            masterslider.setup("main-slider-one", {
            width           : 1700,
            height          : 700,
            minHeight       : 0,
            space           : 0,
            start           : 1,
            grabCursor      : true,
            swipe           : false,
            mouse           : true,
            keyboard        : true,
            layout          : "fullwidth",
            wheel           : false,
            autoplay        : true,
            instantStartLayers:true,
            loop            : true,
            shuffle         : false,
            preload         : 0,
            heightLimit     : true,
            autoHeight      : false,
            smoothHeight    : true,
            endPause        : false,
            overPause       : false,
            fillMode        : "fill",
            centerControls  : true,
            startOnAppear   : false,
            layersMode      : "center",
            autofillTarget  : "",
            hideLayers      : false,
            fullscreenMargin: 0,
            speed           : 10,
            dir             : "h",
            parallaxMode    : 'swipe',
            view            : "fade"
          });
        }
          

        


        // ------------------------------- Home Page Two Slider
        var bannerSlider = $ (".main-banner-slider-two");
        if(bannerSlider.length) {
            bannerSlider.owlCarousel({
              loop:true,
              nav:true,
              navText: ["<i class='flaticon-left-arrow'></i>","<i class='flaticon-right-arrow'></i>"],
              dots:false,
              autoplay:true,
              autoplayTimeout:4000,
              autoplayHoverPause:true,
              smartSpeed:1100,
              lazyLoad:true,
              items:1
          })
        }


        // ------------------------------- Home Page Three Slider
        var bannerSlider = $ (".main-banner-slider-three");
        if(bannerSlider.length) {
            bannerSlider.owlCarousel({
              loop:true,
              nav:false,
              dots:false,
              autoplay:true,
              autoplayTimeout:4000,
              autoplayHoverPause:true,
              smartSpeed:1100,
              lazyLoad:true,
              centerItem:true,
              center: true,
              responsive:{
                    0:{
                        items:1
                    },
                    576:{
                        items:2
                    },
                    992:{
                        items:3
                    },
                    1300:{
                        items:4
                    }
                }
          })
        }


        // ------------------------------- Related Blog Slider
        var tSlider = $ (".related-blog-slider");
        if(tSlider.length) {
            tSlider.owlCarousel({
              loop:true,
              nav:false,
              dots:false,
              autoplay:true,
              autoplayTimeout:4000,
              autoplayHoverPause:true,
              smartSpeed:1100,
              lazyLoad:true,
              responsive:{
                    0:{
                        items:1
                    },
                    500:{
                        items:2
                    },
                    992:{
                        items:3
                    }
                },
          })
        }


        // --------------------------  Blog Details Image Slider
        var rpSlider = $ (".blog-image-slider");
        if(rpSlider.length) {
            rpSlider.owlCarousel({
              loop:true,
              nav:true,
              navText: ["<i class='flaticon-left-arrow'></i>","<i class='flaticon-right-arrow'></i>"],
              dots:false,
              autoplay:true,
              autoplayTimeout:4000,
              autoplayHoverPause:true,
              smartSpeed:1100,
              lazyLoad:true,
              items:1
          })
        }


        // ------------------------------------- Fancybox
        var fancy = $ (".fancybox");
        if(fancy.length) {
          fancy.fancybox({
            arrows: true,
            animationEffect: "zoom-in-out",
            transitionEffect: "zoom-in-out",
          });
        }
        



          // --------------------------------- Contact Form Validation
          if($('.form-validation').length){
            $('.form-validation').validate({ // initialize the plugin
              rules: {
                name: {
                  required: true
                },
                email: {
                  required: true,
                  email: true
                },
                message: {
                  required: true
                }
              },
            submitHandler: function(form) {
              $(form).ajaxSubmit({
                success: function() {
                  $('.form-validation :input').attr('disabled', 'disabled');
                  $('.form-validation').fadeTo( "slow", 1, function() {
                      $(this).find(':input').attr('disabled', 'disabled');
                      $(this).find('label').css('cursor','default');
                      $('#alert-success').fadeIn();
                    });
                  },
                  error: function() {
                    $('.form-validation').fadeTo( "slow", 1, function() {
                      $('#alert-error').fadeIn();
                    });
                  }
                });
              }
            });
          }


          // ---------------------------------- Validation Alert
          var closeButton = $ (".closeAlert");
            if(closeButton.length) {
                closeButton.on('click', function(){
                  $(".alert-wrapper").fadeOut();
                });
                closeButton.on('click', function(){
                  $(".alert-wrapper").fadeOut();
                })
            }
        

        
    });
    
    $(window).load(function() { // makes sure the whole site is loaded

        // -------------------- Site Preloader
        $('#loader').fadeOut(); // will first fade out the loading animation
        $('#loader-wrapper').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
        $('body').delay(350).css({'overflow':'visible'});

        if($(".blog-masonry").length) {
          $('.blog-masonry').masonry({
          // set itemSelector so .grid-sizer is not used in layout
          itemSelector: '.grid-item',
          // use element for option
          columnWidth: '.grid-sizer',
          percentPosition: true
        })
        };
    })
    
})(jQuery)