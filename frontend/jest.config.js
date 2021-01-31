module.exports = {
 moduleFileExtensions: ['ts', 'tsx', 'js'],
 testMatch: ['**/tests/**/*.spec.(ts|tsx|js)'],
 transform: {
   '\\.(ts|tsx|js)$': 'ts-jest'
 },
 moduleNameMapper: {
   '\\.(jpg|jpeg|png|gif|eot|otf|webp|svg|ttf|woff|woff2|mp4|webm|wav|mp3|m4a|aac|oga)$': '<rootDir>/test/setup/fileStub.ts',
   '\\.(css|less|scss|sass)$': 'identity-obj-proxy',
   "^react($|/.+)": '<rootDir>/node_modules/react$1',
   '^dnd-core$': 'dnd-core/dist/cjs',
   '^react-dnd$': 'react-dnd/dist/cjs',
   '^react-dnd-html5-backend$': 'react-dnd-html5-backend/dist/cjs',
 },
 coverageReporters: ['json', 'lcov', 'html', 'text'],
 coverageDirectory: '<rootDir>/build/coverage',
 coveragePathIgnorePatterns: [
   '<rootDir>/node_modules/',
   '<rootDir>/test/'
 ],
 coverageThreshold: {
   global: {
     branches: 90,
     functions: 90,
     lines: 70,
     statements: 70
   }
 },
 setupFiles: [
   '<rootDir>/test/setup.js',
   'jest-localstorage-mock'
 ]
};
