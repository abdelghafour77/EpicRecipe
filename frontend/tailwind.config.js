/** @type {import('tailwindcss').Config} */
const colors = require('tailwindcss/colors')
module.exports = {
    prefix: '',
    mode: 'jit',
    important: false,
    content: [
        "./src/**/*.{html,ts}",
        "./node_modules/flowbite/**/*.js"
    ],
    darkMode: 'class',
    theme: {

        extend: {
            colors: {
                mygreen: {
                    "100": "#C7DEC1",
                    "200": "#9ABF9D",
                    "300": "#417F56",
                    "400": "#39DB4A",
                    "500": "#13a322",
                    "600": "#098216",
                    "700": "#225533",
                },

                offwhite: "#FCFCFC",
                black: "#000",
                darkseagreen: "#90bd95",
                palegreen: "#5fe26c",
                lightgoldenrodyellow: "#c1f1c6",
                honeydew: "#edffef",
                whitesmoke: "#efefef",
                limegreen: {
                    "100": "#53ec62",
                    "200": "#39db4a",
                },
                dimgray: {
                    "100": "#656565",
                    "200": "#555",
                    "300": "#515151",
                    "400": "#4d4d4d",
                },
                salmon: {
                    "100": "#ff7979",
                    "200": "#ff6868",
                },
                white: "#fff",
                darkslategray: {
                    "100": "#4a4a4a",
                    "200": "#454545",
                },
                gray: {
                    100: '#FBFBFB',
                    200: '#EAEAEA',
                    300: '#DFDFDF',
                    400: '#999999',
                    500: '#7F7F7F',
                    600: '#666666',
                    700: '#4C4C4C',
                    800: '#333333',
                    900: '#191919',
                },
                blue: {
                    100: '#E6F0FD',
                    200: '#CCE2FC',
                    300: '#99C5FA',
                    400: '#66A9F7',
                    500: '#338CF5',
                    600: '#0070F4',
                    700: '#0064DA',
                    800: '#0059C2',
                    900: '#004391',
                },
                teal: {
                    100: '#E6FFFA',
                    200: '#B2F5EA',
                    300: '#81E6D9',
                    400: '#4FD1C5',
                    500: '#3ABAB4',
                    600: '#319795',
                    700: '#2C7A7B',
                    800: '#285E61',
                    900: '#234E52',
                },
            },
            boxShadow: {
                xs: '0 0 0 1px rgba(0, 0, 0, 0.16)',
                sm: '0 1px 2px 0 rgba(0, 0, 0, 0.16)',
                default: '0 1px 3px 0 rgba(0, 0, 0, 0.12), 0 1px 2px 0 rgba(0, 0, 0, 0.03)',
                md: '0 4px 6px -1px rgba(0, 0, 0, 0.04), 0 2px 4px -1px rgba(0, 0, 0, 0.03)',
                lg: '0 10px 15px -3px rgba(0, 0, 0, 0.04), 0 4px 6px -2px rgba(0, 0, 0, 0.02)',
                xl: '0 20px 25px -5px rgba(0, 0, 0, 0.12), 0 10px 10px -5px rgba(0, 0, 0, 0.02)',
                '2xl': '0 25px 50px -12px rgba(0, 0, 0, 0.15)',
                inner: 'inset 0 2px 4px 0 rgba(0, 0, 0, 0.04)',
                outline: '0 0 0 3px rgba(66, 153, 225, 0.5)',
                none: 'none',
                custom: '2px 10px 30px rgba(0, 0, 0, 0.1)'
            },
            spacing: {
                '9/16': '56.25%',
                '3/4': '75%',
                '1/1': '100%',
            },
            fontFamily: {
                Playfair: "Playfair Display",
                poppins: "Poppins",
                inter: "Inter",
            },
            borderRadius: {
                "6xl": "25px",
                "21xl": "40px",
                "18xl-5": "37.5px",
                "23xl-5": "42.5px",
                "11xl": "30px",
                "121xl": "140px",
                "22xl": "41px",
            },
            fontSize: {
                xs: '0.75rem',
                sm: '0.875rem',
                base: '1rem',
                lg: '1.125rem',
                xl: '1.25rem',
                '2xl': '1.5rem',
                '3xl': '2rem',
                '4xl': '2.625rem',
                '5xl': '3.25rem',
                '6xl': '5.5rem',
            },
            inset: {
                '1/2': '50%',
                'full': '100%',
            },
            letterSpacing: {
                tighter: '-0.02em',
                tight: '-0.01em',
                normal: '0',
                wide: '0.01em',
                wider: '0.02em',
                widest: '0.4em',
            },
            lineHeight: {
                none: '1',
                tighter: '1.125',
                tight: '1.25',
                snug: '1.375',
                normal: '1.5',
                relaxed: '1.625',
                loose: '2',
                '3': '.75rem',
                '4': '1rem',
                '5': '1.2rem',
                '6': '1.5rem',
                '7': '1.75rem',
                '8': '2rem',
                '9': '2.25rem',
                '10': '2.5rem',
            },
            minWidth: {
                '10': '2.5rem',
                '48': '12rem',
            },
            opacity: {
                '90': '0.9',
            },
            scale: {
                '98': '.98'
            },
            animation: {
                float: 'float 3s ease-in-out infinite',
            },
            keyframes: {
                float: {
                    '0%, 100%': { transform: 'translateY(0)', },
                    '50%': { transform: 'translateY(-5%)', },
                },
            },
            zIndex: {
                '-1': '-1',
            },
        },
        container: {
            padding: {
                DEFAULT: '1rem',
                sm: '2rem',
                lg: '4rem',
                xl: '5rem',
                '2xl': '6rem',
            },
        },
        fontFamily: {
            'Smooch': ['Smooch, cursive'],
            'PoorStory': ['Poor Story, cursive'],
            'Poppins': ['Poppins, sans-serif'],
            'Delius': ['Delius, cursive'],
        },
    },
    variants: {
        extend: {},
        scrollbar: ['dark', 'rounded']
    },
    plugins: [
        require('flowbite/plugin'),
        require('@tailwindcss/forms'),
        require('@tailwindcss/typography'),
        require('@tailwindcss/aspect-ratio'),
        require('tailwind-scrollbar'),
        require('tailwind-scrollbar-hide')
    ],
    // important: true,
}