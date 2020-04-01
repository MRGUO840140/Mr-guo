$(function(){
    $(function(){
        var index = {
            init: function(){
                this.illsHover();   //疾病自诊
            },

            illsHover: function(){
                $('.j-doctors-tab .ills-title-list').find('li').on('mouseover', function(){
                    if(!$(this).hasClass('cur')){
                        $(this).addClass('cur').siblings('li').removeClass('cur');
                        $('.doctors-con').eq($(this).index()).show().siblings('.doctors-con').hide();
                    }
                });
                jQuery('.related-sick-title li').on({
                    'mouseenter' : function(){
                        jQuery(this).addClass('enter').siblings().removeClass('enter');
                    },
                    'mouseleave' : function(){
                        jQuery(this).removeClass('enter');
                    },
                    click: function(){
                        if(!$(this).hasClass('cur')){
                            $(this).addClass('cur').siblings('li').removeClass('cur');
                            $(this).parents('.related-sick-title').siblings('.related-sick-dels').addClass('none');
                            $(this).parents('.related-sick-title').siblings('.related-sick-dels').eq($(this).index()).removeClass('none');
                        }
                    }
                });


                var timer = null;
                jQuery('.related-sick-sex a').on({
                    'click' :  function(){
                        if(!jQuery(this).hasClass('cur')){
                            jQuery(this).addClass('cur').siblings().removeClass('cur');
                            jQuery('.related-sick-turn').eq(0).addClass('cur').siblings('.related-sick-turn').removeClass('cur');
                            jQuery('.related-sick-p').removeClass('active');
                            jQuery('.related-sick-items').addClass('none');
                            if(jQuery('.related-sex-g').hasClass('cur')){
                                jQuery('.related-sick-p.girl').addClass('active');
                                jQuery('.related-sick-items.girl').removeClass('none');
                            }else if(jQuery('.related-sex-m').hasClass('cur')){
                                jQuery('.related-sick-p.man').addClass('active');
                                jQuery('.related-sick-items.man').removeClass('none');
                            }
                        }

                    }
                });
                jQuery('.related-sick-turn').on({
                    mouseenter : function(){
                        jQuery(this).addClass('enter');
                        //jQuery(this).siblings('.related-sick-turn').addClass('cur');
                    },
                    mouseleave : function(){
                        jQuery(this).removeClass('enter');
                        //jQuery(this).siblings('.related-sick-turn').removeClass('cur');
                    },
                    click : function(){
                        if(!$(this).hasClass('cur')){
                            $(this).addClass('cur').siblings('.related-sick-turn').removeClass('cur');
                            if(jQuery('.related-sick-p.man').hasClass('active')){
                                jQuery('.related-sick-p.man').removeClass('active');
                                jQuery('.related-sick-items.man').addClass('none');
                                jQuery('.related-sick-p.man-b').addClass('active');
                                jQuery('.related-sick-items.man-b').removeClass('none');
                            }else if(jQuery('.related-sick-p.man-b').hasClass('active')){
                                jQuery('.related-sick-p.man-b').removeClass('active');
                                jQuery('.related-sick-items.man-b').addClass('none');
                                jQuery('.related-sick-p.man').addClass('active');
                                jQuery('.related-sick-items.man').removeClass('none');
                            }else if(jQuery('.related-sick-p.girl').hasClass('active')){
                                jQuery('.related-sick-p.girl').removeClass('active');
                                jQuery('.related-sick-items.girl').addClass('none');
                                jQuery('.related-sick-p.girl-b').addClass('active');
                                jQuery('.related-sick-items.girl-b').removeClass('none');
                            }else if(jQuery('.related-sick-p.girl-b').hasClass('active')){
                                jQuery('.related-sick-p.girl-b').removeClass('active');
                                jQuery('.related-sick-items.girl-b').addClass('none');
                                jQuery('.related-sick-p.girl').addClass('active');
                                jQuery('.related-sick-items.girl').removeClass('none');
                            }
                        }

                    }
                });
                var curMan = [0],
                    curManB = [0,1,2,3],
                    curGirl = [1],
                    curGirlB = [0,1,2,3];
                jQuery('#map-m area').on({
                    mouseenter : function(){
                        var self = jQuery(this);
                        curMan = [];
                        jQuery('.related-sick-con .man').find('.j-sick-tab').each(function(){
                            if(jQuery(this).css('display') == 'block'){
                                if(jQuery(this).index() > 3){
                                    curMan.push(jQuery(this).index()+1);
                                }else if( jQuery(this).index() == 3){
                                    curMan.push(3);curMan.push(4);
                                }else{
                                    curMan.push(jQuery(this).index());
                                }
                            }
                        });
                        if(!(self.attr('class') == jQuery('#map-m area').eq(curMan[0]).attr('class')||self.attr('class') == jQuery('#map-m area').eq(curMan[1]).attr('class'))){
                            jQuery('.filter-m span').each(function(){
                                if(!(jQuery(this).index() == curMan[0] || jQuery(this).index() == curMan[1])){
                                    jQuery(this).hide();
                                }
                            });

                            if(self.hasClass('map-m-head')){
                                jQuery('.filter-m-head').show();
                            }else if(self.hasClass('map-m-chest')){
                                jQuery('.filter-m-chest').show();
                            }else if(self.hasClass('map-m-belly')){
                                jQuery('.filter-m-belly').show();
                            }else if(self.hasClass('map-m-arm-l') || self.hasClass('map-m-arm-r')){
                                jQuery('.filter-m-arm-l,.filter-m-arm-r').show();
                            }else if(self.hasClass('map-m-sex')){
                                jQuery('.filter-m-sex').show();
                            }else if(self.hasClass('map-m-leg')){
                                jQuery('.filter-m-leg').show();
                            }
                        }
                    }
                });
                jQuery('.filter-m span').on({
                    click : function(){
                        var self = jQuery(this);
                        curMan = [];
                        if(jQuery(this).index() == 3 || jQuery(this).index() == 4){
                            curMan.push(3);curMan.push(4);
                        }else{
                            curMan.push(jQuery(this).index());
                        }
                        //clearTimeout(timer);
                        //timer = setTimeout(function() {
                        if(self.hasClass('filter-m-head')){
                            jQuery('.filter-m-head').show().siblings().hide();
                            jQuery('.related-m-head').show().siblings().hide();
                        }else if(self.hasClass('filter-m-chest')){
                            jQuery('.filter-m-chest').show().siblings().hide();
                            jQuery('.related-m-chest').show().siblings().hide();
                        }else if(self.hasClass('filter-m-belly')){
                            jQuery('.filter-m-belly').show().siblings().hide();
                            jQuery('.related-m-belly').show().siblings().hide();
                        }else if(self.hasClass('filter-m-arm-l') || self.hasClass('filter-m-arm-r')){
                            jQuery('.filter-m span').hide();
                            jQuery('.filter-m-arm-l,.filter-m-arm-r').show();
                            jQuery('.related-m-arm').show().siblings().hide();
                        }else if(self.hasClass('filter-m-sex')){
                            jQuery('.filter-m-sex').show().siblings().hide();
                            jQuery('.related-m-sex').show().siblings().hide();
                        }else if(self.hasClass('filter-m-leg')){
                            jQuery('.filter-m-leg').show().siblings().hide();
                            jQuery('.related-m-leg').show().siblings().hide();
                        }
                        //}, 200);
                    },
                    mouseleave : function(){
                        if(!(jQuery(this).index() == curMan[0] || jQuery(this).index() == curMan[1])){
                            if(jQuery(this).hasClass('filter-m-arm-l') || jQuery(this).hasClass('filter-m-arm-r')){
                                jQuery('.filter-m-arm-l,.filter-m-arm-r').hide();
                            }else{
                                jQuery(this).hide();
                            }
                        }
                    }
                });

                jQuery('#map-m-b area').on({
                    mouseenter : function() {
                        var self = jQuery(this);
                        curManB = [];
                        jQuery('.related-sick-con .man-b').find('.j-sick-tab').each(function(){
                            if(jQuery(this).css('display') == 'block'){
                                if(jQuery(this).index() == 0){
                                    curManB.push(0,1,2,3);
                                }else if(jQuery(this).index() == 1){
                                    curManB.push(4);
                                }else if(jQuery(this).index() == 2){
                                    curManB.push(5);
                                }
                            }
                        });
                        if(!(self.attr('class') == jQuery('#map-m-b area').eq(curManB[0]).attr('class')||self.attr('class') == jQuery('#map-m-b area').eq(curManB[1]).attr('class'))) {

                            jQuery('.filter-m-b span').each(function () {
                                if (!(jQuery(this).index() == curManB[0] || jQuery(this).index() == curManB[1] || jQuery(this).index() == curManB[2] || jQuery(this).index() == curManB[3])) {
                                    jQuery(this).hide();
                                }
                            });
                            //clearTimeout(timer);
                            //timer = setTimeout(function() {
                            if (self.hasClass('map-m-b-waist')) {
                                jQuery('.filter-m-b-waist').show();
                            } else if (self.hasClass('map-m-b-butt')) {
                                jQuery('.filter-m-b-butt').show();
                            } else if (self.hasClass('map-m-b-top') || self.hasClass('map-m-b-leg')) {
                                jQuery('.filter-m-b-top,.filter-m-b-arm-l,.filter-m-b-arm-r,.filter-m-b-leg').show();
                            }
                            // }, 200);
                        }
                    }
                });
                jQuery('.filter-m-b span').on({
                    click : function() {
                        var self = jQuery(this);
                        curManB = [];
                        if(jQuery(this).index() == 0 || jQuery(this).index() == 1 || jQuery(this).index() == 2 || jQuery(this).index() == 3){
                            curManB.push(0);curManB.push(1);curManB.push(2);curManB.push(3);
                        }else{
                            curManB.push(jQuery(this).index());
                        }
                        //clearTimeout(timer);
                        // timer = setTimeout(function() {
                        if (self.hasClass('filter-m-b-waist')) {
                            jQuery('.filter-m-b-waist').show().siblings().hide();
                            jQuery('.related-m-b-waist').show().siblings().hide();
                        }else if (self.hasClass('filter-m-b-butt')) {
                            jQuery('.filter-m-b-butt').show().siblings().hide();
                            jQuery('.related-m-b-butt').show().siblings().hide();
                        } else if (self.hasClass('filter-m-b-top') || self.hasClass('filter-m-b-leg')) {
                            jQuery('.filter-m-b span').hide();
                            jQuery('.filter-m-b-top,.filter-m-b-arm-l,.filter-m-b-arm-r,.filter-m-b-leg').show();
                            jQuery('.related-m-b-top').show().siblings().hide();
                        }
                        //}, 200);
                    },
                    mouseleave : function(){
                        if(!(jQuery(this).index() == curManB[0] || jQuery(this).index() == curManB[1] || jQuery(this).index() == curManB[2] || jQuery(this).index() == curManB[3])){
                            if(jQuery(this).hasClass('filter-m-b-top') || jQuery(this).hasClass('filter-m-b-arm-l') || jQuery(this).hasClass('filter-m-b-arm-r') || jQuery(this).hasClass('filter-m-b-leg')){
                                jQuery('.filter-m-b-top,.filter-m-b-arm-l,.filter-m-b-arm-r,.filter-m-b-leg').hide();
                            }else{
                                jQuery(this).hide();
                            }
                        }
                    }
                });

                jQuery('#map-g area').on({
                    mouseenter : function(){
                        var self = jQuery(this);
                        curGirl = [];
                        jQuery('.related-sick-con .girl').find('.j-sick-tab').each(function(){
                            if(jQuery(this).css('display') == 'block'){
                                if(jQuery(this).index() > 2){
                                    curGirl.push(jQuery(this).index()+1);
                                }else if( jQuery(this).index() == 2){
                                    curGirl.push(2);curGirl.push(3);
                                }else{
                                    curGirl.push(jQuery(this).index());
                                }
                            }
                        });
                        if(!(self.attr('class') == jQuery('#map-g area').eq(curGirl[0]).attr('class')||self.attr('class') == jQuery('#map-g area').eq(curGirl[1]).attr('class'))){
                            jQuery('.filter-g span').each(function(){
                                if(!(jQuery(this).index() == curGirl[0] || jQuery(this).index() == curGirl[1])){
                                    jQuery(this).hide();
                                }
                            });
                            if(self.hasClass('map-g-head')){
                                jQuery('.filter-g-head').show();
                            }else if(self.hasClass('map-g-chest')){
                                jQuery('.filter-g-chest').show();
                            }else if(self.hasClass('map-g-arm-l') || self.hasClass('map-g-arm-r')){
                                jQuery('.filter-g-arm-l,.filter-g-arm-r').show();
                            }else if(self.hasClass('map-g-waist')){
                                jQuery('.filter-g-waist').show();
                            }else if(self.hasClass('map-g-butt')){
                                jQuery('.filter-g-butt').show();
                            }else if(self.hasClass('map-g-leg')){
                                jQuery('.filter-g-leg').show();
                            }
                        }
                    }
                });
                jQuery('.filter-g span').on({
                    click : function(){
                        var self = jQuery(this);
                        curGirl = [];
                        if(jQuery(this).index() == 2 || jQuery(this).index() == 3){
                            curGirl.push(2);curGirl.push(3);
                        }else{
                            curGirl.push(jQuery(this).index());
                        }
                        //clearTimeout(timer);
                        //timer = setTimeout(function() {
                        if(self.hasClass('filter-g-head')){
                            jQuery('.filter-g-head').show().siblings().hide();
                            jQuery('.related-g-head').show().siblings().hide();
                        }else if(self.hasClass('filter-g-chest')){
                            jQuery('.filter-g-chest').show().siblings().hide();
                            jQuery('.related-g-chest').show().siblings().hide();
                        }else if(self.hasClass('filter-g-arm-l') || self.hasClass('filter-g-arm-r')){
                            jQuery('.filter-g span').hide();
                            jQuery('.filter-g-arm-l,.filter-g-arm-r').show();
                            jQuery('.related-g-arm').show().siblings().hide();
                        }else if(self.hasClass('filter-g-waist')){
                            jQuery('.filter-g-waist').show().siblings().hide();
                            jQuery('.related-g-waist').show().siblings().hide();
                        }else if(self.hasClass('filter-g-butt')){
                            jQuery('.filter-g-butt').show().siblings().hide();
                            jQuery('.related-g-butt').show().siblings().hide();
                        }else if(self.hasClass('filter-g-leg')){
                            jQuery('.filter-g-leg').show().siblings().hide();
                            jQuery('.related-g-leg').show().siblings().hide();
                        }
                        //}, 200);
                    },
                    mouseleave : function(){
                        if(!(jQuery(this).index() == curGirl[0] || jQuery(this).index() == curGirl[1])){
                            if(jQuery(this).hasClass('filter-g-arm-l') || jQuery(this).hasClass('filter-g-arm-r')){
                                jQuery('.filter-g-arm-l,.filter-g-arm-r').hide();
                            }else{
                                jQuery(this).hide();
                            }
                        }
                    }
                });

                jQuery('#map-g-b area').on({
                    mouseenter : function() {
                        var self = jQuery(this);
                        curGirlB = [];
                        jQuery('.related-sick-con .girl-b').find('.j-sick-tab').each(function(){
                            if(jQuery(this).css('display') == 'block'){
                                if(jQuery(this).index() == 0){
                                    curGirlB.push(0,1,2,3);
                                }else if(jQuery(this).index() == 1){
                                    curGirlB.push(4);
                                }else if(jQuery(this).index() == 2){
                                    curGirlB.push(5);
                                }
                            }
                        });
                        if(!(self.attr('class') == jQuery('#map-g-b area').eq(curGirlB[0]).attr('class')||self.attr('class') == jQuery('#map-g-b area').eq(curGirlB[1]).attr('class'))) {
                            jQuery('.filter-g-b span').each(function () {
                                if (!(jQuery(this).index() == curGirlB[0] || jQuery(this).index() == curGirlB[1] || jQuery(this).index() == curGirlB[2] || jQuery(this).index() == curGirlB[3])) {
                                    jQuery(this).hide();
                                }
                            });
                            //clearTimeout(timer);
                            //timer = setTimeout(function() {
                            if (self.hasClass('map-g-b-waist')) {
                                jQuery('.filter-g-b-waist').show();
                            } else if (self.hasClass('map-g-b-butt')) {
                                jQuery('.filter-g-b-butt').show();
                            } else if (self.hasClass('map-g-b-top') || self.hasClass('map-g-b-leg')) {
                                jQuery('.filter-g-b-top,.filter-g-b-arm-l,.filter-g-b-arm-r,.filter-g-b-leg').show();
                            }
                            // }, 200);
                        }
                    }
                });
                jQuery('.filter-g-b span').on({
                    click : function() {
                        var self = jQuery(this);
                        curGirlB = [];
                        if(jQuery(this).index() == 0 || jQuery(this).index() == 1 || jQuery(this).index() == 2 || jQuery(this).index() == 3){
                            curGirlB.push(0);curGirlB.push(1);curGirlB.push(2);curGirlB.push(3);
                        }else{
                            curGirlB.push(jQuery(this).index());
                        }
                        if (self.hasClass('filter-g-b-waist')) {
                            jQuery('.filter-g-b-waist').show().siblings().hide();
                            jQuery('.related-g-b-waist').show().siblings().hide();
                        }else if (self.hasClass('filter-g-b-butt')) {
                            jQuery('.filter-g-b-butt').show().siblings().hide();
                            jQuery('.related-g-b-butt').show().siblings().hide();
                        } else if (self.hasClass('filter-g-b-top') || self.hasClass('filter-g-b-leg')) {
                            jQuery('.filter-g-b span').hide();
                            jQuery('.filter-g-b-top,.filter-g-b-arm-l,.filter-g-b-arm-r,.filter-g-b-leg').show();
                            jQuery('.related-g-b-top').show().siblings().hide();
                        }
                    },
                    mouseleave : function(){
                        if(!(jQuery(this).index() == curGirlB[0] || jQuery(this).index() == curGirlB[1] || jQuery(this).index() == curGirlB[2] || jQuery(this).index() == curGirlB[3])){
                            if(jQuery(this).hasClass('filter-g-b-top') || jQuery(this).hasClass('filter-g-b-arm-l') || jQuery(this).hasClass('filter-g-b-arm-r') || jQuery(this).hasClass('filter-g-b-leg')){
                                jQuery('.filter-g-b-top,.filter-g-b-arm-l,.filter-g-b-arm-r,.filter-g-b-leg').hide();
                            }else{
                                jQuery(this).hide();
                            }
                        }
                    }
                });
            },

        }

        index.init();
    });

});