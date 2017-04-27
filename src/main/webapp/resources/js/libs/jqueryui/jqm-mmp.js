
(function ($, window, document, undefined) {
    $.widget("mobile.mmp", $.mobile.widget, {
        options: {
            text: 'Multiple Month Picker',
            theme: 'a',
            id: 'mmp',
            //months: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
            months: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
            value: []
        },
        value: function (value) {
            if (value === undefined) {
                return this.options.value;
            }

            this.options.value = value;
            this._values = ',' + value.join(',') + ',';
            this._check();
        },
        _currentYear: (new Date()).getFullYear(),
        _values: ',',
        _check: function () {
            var that = this;
            this.element.find('input').each(function () {
                if (that._values.indexOf(',' + $(this).val() + ',') >= 0) {
                    $(this).prop('checked', true).checkboxradio('refresh');
                } else {
                    $(this).prop('checked', false).checkboxradio('refresh');
                }
            });
        },
        _create: function () {
            this.element.css('text-align', 'center');

            this.element.append('<div id="mmp-header" data-role="controlgroup" data-type="horizontal"></div>');
            this.element.children('div').append('<button id="btnPreviousYear" data-iconpos="notext" data-icon="arrow-l">Previous year</button>');
            this.element.children('div').append('<button id="yearLabel" onclick="return false;" style="width: 100px;">' + this._currentYear + '</button>');
            this.element.children('div').append('<button id="btnNextYear" data-iconpos="notext" data-icon="arrow-r">Next year</button>');

            for (var i = 0; i < 4; i++) {
                this.element.append('<fieldset id="mmp-months-row-' + i + '" data-role="controlgroup" data-type="horizontal"></fieldset>');
                for (var j = 0; j < 3; j++) {
                    var month = this._currentYear + '-' + this._zeros(1 + j + 3 * i, 2);
                    this.element.find('#mmp-months-row-' + i).append('<input type="radio" name="month" id="' + month + '" value="' + month + '" data-wrapper-class="mmp-month" />');
                    this.element.find('#mmp-months-row-' + i).append('<label for="' + month + '" style="width: text-align: center;">' + this.options.months[j + 3 * i] + '</label>');
                }
            }

            $('<style>.mmp-month { width: 85px; }</style>').appendTo('head');
            $('<style>.mmp-month > label { text-align: center; }</style>').appendTo('head');

            $('body').trigger('create');

            var that = this;

            this.element.find('#btnPreviousYear').click(function () {
                that._currentYear--;
                that.element.html('');
                that._create();

            });

            this.element.find('#btnNextYear').click(function () {
                that._currentYear++;
                that.element.html('');
                that._create();
            });

            this.element.children('fieldset').find('label').css('text-align', 'center');
            this.element.children('fieldset').find('input').click(function () {

            });

            this._check();
        },
        _zeros: function (text, size) {
            var temp = text + '';
            while (temp.length < size) {
                temp = '0' + temp;
            }
            return temp;
        }
    });
})(jQuery, window, document);
 